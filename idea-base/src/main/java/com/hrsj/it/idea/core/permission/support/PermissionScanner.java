
package com.hrsj.it.idea.core.permission.support;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.web.context.WebApplicationContext;
import com.hrsj.it.idea.core.context.manager.IdeaContextManager;
import com.hrsj.it.idea.core.permission.IPermissionOperateable;
import com.hrsj.it.idea.core.permission.annotation.IdeaOperation;
import com.hrsj.it.idea.core.permission.annotation.IdeaResource;
import com.hrsj.it.idea.core.permission.constant.ServiceType;
import com.hrsj.it.idea.core.permission.data.IResourceData;
import com.hrsj.it.idea.core.permission.domain.ResourceVO;
import com.hrsj.it.idea.domain.ServiceResponse;

@Named
public class PermissionScanner implements IPermissionOperateable
{

    @Inject
    private IResourceData resourceData;

    @Override
    public ServiceResponse<Boolean> syncIdeaPermission()
    {
        List<ResourceVO> resourceLists = scanIdeaResources();

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
        List<ResourceVO> resourceLists = scanIdeaResources();
        saveOrUpdateResources( resourceLists );

        // 删除未被更新的资源
        resourceData.deleteDisableApplicationResourceByServiceType(
                ServiceType.SERVICE, appName );

        // todo 删除失效的用户角色-权限映射

        return null;
    }

    private List<ResourceVO> scanIdeaResources()
    {
        WebApplicationContext application = IdeaContextManager.getIdeaContext()
                .getApplicationContext();
        Map<String, Object> resourceBeans = application
                .getBeansWithAnnotation( IdeaResource.class );

        List<ResourceVO> resourceLists = parseResourecsBeans( resourceBeans );

        return resourceLists;
    }

    private List<ResourceVO> parseResourecsBeans(
            Map<String, Object> resourceBeans )
    {
        List<ResourceVO> resources = new ArrayList<>( resourceBeans.size() );
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

    private void addToResource( String className, List<ResourceVO> resources )
    {
        Class<?> clazz = null;
        ResourceVO resource = null;
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
                    resource = new ResourceVO();
                    resource.setAppName( appName );
                    resource.setResourceType( ServiceType.SERVICE );
                    resource.setResourceCode( resourceCode );
                    resource.setResourceDesc( resourceDesc );
                    resource.setOperationCode( operation.code() );
                    resource.setOpetationDesc( operation.desc() );
                    resources.add( resource );
                }
            }

        } catch ( ClassNotFoundException e )
        {
            e.printStackTrace();
        }

    }

    private void saveOrUpdateResources( List<ResourceVO> resources )
    {
        ResourceVO dbResourcesVO = null;
        for ( ResourceVO resource : resources )
        {
            dbResourcesVO = resourceData.queryResoure(
                    resource.getResourceCode(), ServiceType.SERVICE,
                    resource.getOperationCode(), resource.getAppName() );
            resource.setAvailable( true );
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
