
package com.idea.it.core.context.manager;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idea.it.core.context.IdeaContext;
import com.idea.it.core.context.constants.IdeaContextConstants;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月8日 新建
 */
public class IdeaContextManager
{
    private static IdeaContext instance = null;

    private static final ThreadLocal<HttpServletRequest> requestMaps = new ThreadLocal<>();

    private static final ThreadLocal<HttpServletResponse> responseMaps = new ThreadLocal<>();

    private IdeaContextManager()
    {
    }

    public static void setServletContext( ServletContext context )
    {
        if ( null == instance && null != context )
        {
            String appName = (String)context
                    .getInitParameter( IdeaContextConstants.APP_NAME );

            IdeaContext ideaContext = new IdeaContext();
            ideaContext.setServletContext( context );
            ideaContext.setAppName( appName );

            instance = ideaContext;
        }
    }

    public static IdeaContext getIdeaContext()
    {
        return instance;
    };

    public static void setRequest( HttpServletRequest request )
    {
        requestMaps.set( request );
    }

    public static void setResponse( HttpServletResponse response )
    {
        responseMaps.set( response );
    }

    public static HttpServletRequest getRequest()
    {
        return requestMaps.get();
    }

    public static HttpServletResponse getResponse()
    {
        return responseMaps.get();
    }

}
