
package com.idea.it.core.context.filter;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import com.idea.it.core.context.IIdeaServletHandler;
import com.idea.it.core.context.IdeaContext;
import com.idea.it.core.context.constants.IdeaDispatcherConstants;
import com.idea.it.core.context.manager.IdeaContextManager;
import com.idea.it.core.environment.IEnvironmentOperatable;
import com.idea.it.core.menue.IMenueOperatable;
import com.idea.it.core.permission.IPermissionOperateable;
import com.idea.it.resource.IdeaResources;
import com.idea.it.web.upload.IdeaFileUpload;

/**
 * @ClassName: IdeaResourceDispatcher
 * @Description: jar资源处理
 * @author guanhaobi
 * @date 2017年8月25日 下午8:05:28
 */
public class IdeaResourceDispatcher implements Filter
{

    /**
     * 文件头
     */
    private static final Map<String, String> MINE_TYPE_MAP;

    /**
     * 默认文件头
     */
    private static final String DEFAULT_MINE_TYPE = "application/octet-stream";

    static
    {
        MINE_TYPE_MAP = new HashMap<String, String>();
        MINE_TYPE_MAP.put( "js", "application/javascript;charset=utf-8" );
        MINE_TYPE_MAP.put( "css", "text/css;charset=utf-8" );
        MINE_TYPE_MAP.put( "gif", "image/gif" );
        MINE_TYPE_MAP.put( "jpg", "image/jpeg" );
        MINE_TYPE_MAP.put( "jpeg", "image/jpeg" );
        MINE_TYPE_MAP.put( "png", "image/png" );
        MINE_TYPE_MAP.put( "html", "text/html;charset=utf-8" );
    }

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

        String resourcePath = request.getRequestURI()
                .substring( request.getContextPath().length() );
        // 默认跳转到框架首页
        if ( resourcePath.equals( "/" ) )
        {
            resourcePath = "/" + IdeaResources.IDEA_RESOURCE_PATH
                    + "/index/html/index.html";
        }
        // 获取jar中的静态资源
        if ( resourcePath
                .startsWith( "/" + IdeaResources.IDEA_RESOURCE_PATH + "/" ) )
        {
            dispatchIdeaStaticRequest( request, response, resourcePath );
        } else
        {
            dispatchRequest( request, response, chain );
        }
    }

    private void dispatchIdeaStaticRequest( HttpServletRequest request,
            HttpServletResponse response, String resourcePath )
            throws IOException
    {
        InputStream inputStream = getIdeaResource( request, response,
                resourcePath );

        String ext = FilenameUtils.getExtension( resourcePath ).toLowerCase();
        String contentType = MINE_TYPE_MAP.get( ext );
        if ( contentType == null )
        {
            contentType = DEFAULT_MINE_TYPE;
        }
        response.setContentType( contentType );

        ServletOutputStream outputStream = response.getOutputStream();
        try
        {
            int size = IOUtils.copy( inputStream, outputStream ); // 向输出流输出内容
            response.setContentLength( size );
        } finally
        {
            IOUtils.closeQuietly( inputStream );
            IOUtils.closeQuietly( outputStream );
        }
    }

    @Override
    public void destroy()
    {
        // TODO Auto-generated method stub
    }

    private InputStream getIdeaResource( HttpServletRequest request,
            HttpServletResponse response, String resourcePath )
            throws IOException
    {

        InputStream inputstream = null;
        resourcePath = resourcePath
                .substring( IdeaResources.IDEA_RESOURCE_PATH.length() + 2 );
        URL resource = IdeaResources.class.getResource( resourcePath );
        if ( resource == null )
        {
            response.sendError( HttpServletResponse.SC_NOT_FOUND );
            return inputstream;
        }

        inputstream = resource.openStream();
        if ( null == inputstream )
        {
            response.sendError( HttpServletResponse.SC_NOT_FOUND );
            return inputstream;
        }

        return inputstream;
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
