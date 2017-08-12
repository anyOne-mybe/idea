
package com.idea.it.core.context.filter;

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
import com.idea.it.core.context.IIdeaServletHandler;
import com.idea.it.core.context.IdeaContext;
import com.idea.it.core.context.constants.IdeaDispatcherConstants;
import com.idea.it.core.context.manager.IdeaContextManager;
import com.idea.it.core.environment.IEnvironmentOperatable;
import com.idea.it.core.menue.IMenueOperatable;
import com.idea.it.core.permission.IPermissionOperateable;
import com.idea.it.web.upload.IdeaFileUpload;

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

        handleThreadLocal( request, response );

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
        response.setCharacterEncoding( "utf-8" );

        String path = request.getServletPath();
        String appName = IdeaContextManager.getIdeaContext().getAppName();

        // 文件上传
        if ( StringUtils.startsWith( path,
                IdeaDispatcherConstants.IDEA_SERVLET_UPLOAD ) )
        {
            handleFileUpload( request, response, appName );
            return;
        }

        // 同步权限
        if ( StringUtils.startsWith( path,
                IdeaDispatcherConstants.IDEA_SERVLET_PERMISSION ) )
        {
            handleIdeaPremission( request, response, appName );
            return;
        }

        // 查询菜单
        if ( StringUtils.startsWith( path,
                IdeaDispatcherConstants.IDEA_MENUE ) )
        {
            handleIdeaMenue( request, response, appName );
            return;
        }

        if ( StringUtils.startsWith( path,
                IdeaDispatcherConstants.IDEA_BUILD_ENVIRONMENT ) )
        {
            handleEnvironment( request, response, appName );
            return;
        }

        chain.doFilter( request, response );
    }

    private void handleEnvironment( HttpServletRequest request,
            HttpServletResponse response, String appName ) throws IOException
    {
        IdeaContext ideaContext = IdeaContextManager.getIdeaContext();
        IIdeaServletHandler environmentBuilder = ideaContext
                .getBean( IEnvironmentOperatable.class );

        environmentBuilder.handleRequest( request, response, appName );
    }

    private void handleIdeaMenue( HttpServletRequest request,
            HttpServletResponse response, String appName ) throws IOException
    {
        IdeaContext ideaContext = IdeaContextManager.getIdeaContext();
        IIdeaServletHandler menueOperater = ideaContext
                .getBean( IMenueOperatable.class );

        menueOperater.handleRequest( request, response, appName );
    }

    private void handleIdeaPremission( HttpServletRequest request,
            HttpServletResponse response, String appName ) throws IOException
    {
        IdeaContext ideaContext = IdeaContextManager.getIdeaContext();
        IIdeaServletHandler permissionScanner = ideaContext
                .getBean( IPermissionOperateable.class );

        permissionScanner.handleRequest( request, response, appName );
    }

    private void handleFileUpload( HttpServletRequest request,
            HttpServletResponse response, String appName )
            throws ServletException, IOException
    {
        // 文件上传
        IdeaContext ideaContext = IdeaContextManager.getIdeaContext();
        IdeaFileUpload fileUploadFactory = ideaContext
                .getBean( IdeaFileUpload.class );

        fileUploadFactory.execute( request, response );
    }

    private void handleThreadLocal( HttpServletRequest request,
            HttpServletResponse response )
    {
        IdeaContextManager.setRequest( request );
        IdeaContextManager.setResponse( response );
    }

}
