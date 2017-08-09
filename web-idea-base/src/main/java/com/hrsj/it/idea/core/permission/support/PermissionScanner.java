
package com.hrsj.it.idea.core.permission.support;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.web.context.WebApplicationContext;
import com.hrsj.it.idea.core.context.manager.IdeaContextManager;
import com.hrsj.it.idea.core.permission.IPermissionOperateable;
import com.hrsj.it.idea.core.permission.annotation.IdeaResource;
import com.hrsj.it.idea.core.permission.dao.IdeaResourceMapper;
import com.hrsj.it.idea.domain.ServiceResponse;

@Named
public class PermissionScanner implements IPermissionOperateable
{
    @Inject
    private IdeaResourceMapper ideaResourceMapper;

    @Override
    public ServiceResponse<Boolean> syncIdeaPermission()
    {
        WebApplicationContext application = IdeaContextManager.getIdeaContext()
                .getApplicationContext();
        Map<String, Object> resourceBeans = application
                .getBeansWithAnnotation( IdeaResource.class );

        List<com.hrsj.it.idea.core.permission.domain.IdeaResource> resources = parseResourecsBeans(
                resourceBeans );

        com.hrsj.it.idea.core.permission.domain.IdeaResource aa = ideaResourceMapper
                .selectByPrimaryKey( 1 );
        System.out.println( aa );
        return null;
    }

    @Override
    public ServiceResponse<Boolean> deleteUnUsedPermission()
    {
        // TODO Auto-generated method stub
        return null;
    }

    private List<com.hrsj.it.idea.core.permission.domain.IdeaResource> parseResourecsBeans(
            Map<String, Object> resourceBeans )
    {
        // TODO Auto-generated method stub
        return null;
    }

}
