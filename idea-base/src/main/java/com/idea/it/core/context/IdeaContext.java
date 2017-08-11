
package com.idea.it.core.context;
/**  
* 类说明   
*  
* @author ****  
* @date 2017年8月8日  新建  
*/

import java.io.Serializable;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class IdeaContext implements Serializable
{

    private static final long serialVersionUID = 8969928052686540964L;
    private ServletContext servletContext;
    private String appName;

    public WebApplicationContext getApplicationContext()
    {
        WebApplicationContext application = WebApplicationContextUtils
                .getRequiredWebApplicationContext( this.servletContext );

        return application;
    };

    public ServletContext getServletContext()
    {
        return servletContext;
    }

    public void setServletContext( ServletContext servletContext )
    {
        this.servletContext = servletContext;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName( String appName )
    {
        this.appName = appName;
    }

}
