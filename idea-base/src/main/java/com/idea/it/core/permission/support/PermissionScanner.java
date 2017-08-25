
package com.idea.it.core.permission.support;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import com.idea.it.common.domain.ServiceResponse;
import com.idea.it.common.util.UserHelper;
import com.idea.it.core.context.manager.IdeaContextManager;
import com.idea.it.core.permission.IPermissionOperateable;
import com.idea.it.core.permission.annotation.IdeaOperation;
import com.idea.it.core.permission.annotation.IdeaResource;
import com.idea.it.core.permission.constant.ServiceType;
import com.idea.it.core.permission.data.IResourceData;
import com.idea.it.core.permission.domain.Resource;
import com.idea.it.core.user.domain.TplUser;

@Named
public class PermissionScanner implements IPermissionOperateable
{

    @Inject
    private IResourceData resourceData;

    @Override
    public void handleRequest( HttpServletRequest request,
            HttpServletResponse response, String appName ) throws IOException
    {
        String operateType = request.getParameter( "operateType" );
        if ( StringUtils.equals( operateType, "update" ) )
        {
            // 同步权限
            syncIdeaPermission();
        } else if ( StringUtils.equals( operateType, "delete" ) )
        {
            // 删除失效的权限
            deleteUnUsedPermission();
        }

    }

    @Override
    public ServiceResponse<Boolean> syncIdeaPermission()
    {
        List<Resource> resourceLists = scanIdeaResources();

        saveOrUpdateResources( resourceLists );

        return null;
    }

    @Override
    public ServiceResponse<Boolean> deleteUnUsedPermission()
    {

        String appName = IdeaContextManager.getIdeaContext().getAppName();
        // 将资源置为失效
        resourceData.disableApplicationResourceByServiceType(
                ServiceType.SERVICE, appName );

        // 更新资源
        List<Resource> resourceLists = scanIdeaResources();
        saveOrUpdateResources( resourceLists );

        // 删除未被更新的资源
        resourceData.deleteDisableApplicationResourceByServiceType(
                ServiceType.SERVICE, appName );

        // todo 删除失效的用户角色-权限映射

        return null;
    }

    private List<Resource> scanIdeaResources()
    {
        WebApplicationContext application = IdeaContextManager.getIdeaContext()
                .getApplicationContext();
        Map<String, Object> resourceBeans = application
                .getBeansWithAnnotation( IdeaResource.class );

        List<Resource> resourceLists = parseResourecsBeans( resourceBeans );

        return resourceLists;
    }

    private List<Resource> parseResourecsBeans(
            Map<String, Object> resourceBeans )
    {
        List<Resource> resources = new ArrayList<>( resourceBeans.size() );
        String className = null;
        String beanName = null;
        for ( Map.Entry<String, Object> entry : resourceBeans.entrySet() )
        {
            beanName = entry.getValue().toString();
            className = beanName.substring( 0, beanName.indexOf( "@" ) );
            addToResource( className, resources );
        }

        return resources;
    }

    private void addToResource( String className, List<Resource> resources )
    {
        Class<?> clazz = null;
        Resource resource = null;
        String resourceCode = null;
        String resourceDesc = null;
        try
        {
            clazz = Class.forName( className );
            IdeaResource res = clazz.getAnnotation( IdeaResource.class );
            resourceCode = res.code();
            resourceDesc = res.desc();

            Method[] methods = clazz.getMethods();
            IdeaOperation operation = null;
            String appName = IdeaContextManager.getIdeaContext().getAppName();
            for ( Method m : methods )
            {
                operation = m.getAnnotation( IdeaOperation.class );
                if ( null != operation )
                {
                    resource = new Resource();
                    resource.setAppName( appName );
                    resource.setType( ServiceType.SERVICE );
                    resource.setResourceCode( resourceCode );
                    resource.setResourceName( resourceDesc );
                    resource.setOperateCode( operation.code() );
                    resource.setOperateName( operation.desc() );
                    resources.add( resource );
                }
            }

        } catch ( ClassNotFoundException e )
        {
            e.printStackTrace();
        }

    }

    private void saveOrUpdateResources( List<Resource> resources )
    {
        Resource dbResourcesVO = null;
        Date currentTime = new Date();
        TplUser user = UserHelper.getCurrentUser();
        for ( Resource resource : resources )
        {
            dbResourcesVO = resourceData.queryResoure(
                    resource.getResourceCode(), ServiceType.SERVICE,
                    resource.getOperateCode(), resource.getAppName() );
            resource.setAvailable( true );
            resource.setUpdateDate( currentTime );
            resource.setUpdateBy( user.getId() );

            if ( null != dbResourcesVO )
            {
                resource.setId( dbResourcesVO.getId() );
                resourceData.updateResource( resource );
            } else
            {
                resourceData.insert( resource );
            }
        }
    }

}
