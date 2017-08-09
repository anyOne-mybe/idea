
package com.hrsj.it.idea.core.context.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import com.hrsj.it.idea.core.context.IdeaContext;
import com.hrsj.it.idea.core.context.constants.IdeaDispatcherConstants;
import com.hrsj.it.idea.core.context.manager.IdeaContextManager;
import com.hrsj.it.idea.core.permission.IPermissionOperateable;
import com.hrsj.it.idea.core.upload.IdeaFileUpload;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月8日 新建
 */
public class IdeaResourceDispatcher implements Filter
{
    @Override
    public void init( FilterConfig filterConfig ) throws ServletException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter( ServletRequest req, ServletResponse res,
            FilterChain chain ) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;

        handleLocal( request, response );

        dispatchRequest( request, response, chain );
    }

    @Override
    public void destroy()
    {
        // TODO Auto-generated method stub
    }

    private void dispatchRequest( HttpServletRequest request,
            HttpServletResponse response, FilterChain chain )
            throws ServletException, IOException
    {
        String path = request.getServletPath();

        // 文件上传
        if ( StringUtils.startsWith( path,
                "/" + IdeaDispatcherConstants.IDEA_SERVLET_UPLOAD ) )
        {
            handleFileUpload( request, response );
            return;
        }

        // 同步权限
        if ( StringUtils.startsWith( path,
                "/" + IdeaDispatcherConstants.IDEA_SERVLET_PERMISSION ) )
        {
            handleIdeaPremission( request, response );
            return;
        }

        chain.doFilter( request, response );
    }

    private void handleIdeaPremission( HttpServletRequest request,
            HttpServletResponse response )
    {
        IdeaContext ideaContext = IdeaContextManager.getIdeaContext();
        WebApplicationContext application = ideaContext.getApplicationContext();
        IPermissionOperateable permissionScanner = application
                .getBean( IPermissionOperateable.class );
        permissionScanner.syncIdeaPermission();
    }

    private void handleFileUpload( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
    {
        // 文件上传
        IdeaContext ideaContext = IdeaContextManager.getIdeaContext();
        WebApplicationContext application = ideaContext.getApplicationContext();

        IdeaFileUpload fileUploadFactory = application
                .getBean( IdeaFileUpload.class );

        fileUploadFactory.execute( request, response );
    }

    private void handleLocal( HttpServletRequest request,
            HttpServletResponse response )
    {
        IdeaContextManager.setRequest( request );
        IdeaContextManager.setResponse( response );
    }

}
