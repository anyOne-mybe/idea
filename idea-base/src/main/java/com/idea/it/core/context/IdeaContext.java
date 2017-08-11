
package com.idea.it.core.context;
/**  
* 类说明   
*  
* @author ****  
* @date 2017年8月8日  新建  
*/

import java.io.Serializable;
import javax.servlet.ServletContext;
import org.springframework.beans.BeansException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class IdeaContext implements Serializable
{

    private static final long serialVersionUID = 8969928052686540964L;
    private ServletContext servletContext;
    private String appName;
    private WebApplicationContext applicationContext;

    public WebApplicationContext getApplicationContext()
    {
        if ( this.applicationContext == null )
        {
            synchronized ( this )
            {
                if ( this.applicationContext == null )
                {
                    WebApplicationContext application = WebApplicationContextUtils
                            .getRequiredWebApplicationContext(
                                    this.servletContext );
                    this.applicationContext = application;
                }
            }
        }

        return this.applicationContext;
    };

    public ServletContext getServletContext()
    {
        return servletContext;
    }

    public <T> T getBean( Class<T> requiredType ) throws BeansException
    {
        return getApplicationContext().getBean( requiredType );
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName( String appName )
    {
        this.appName = appName;
    }

    public void setServletContext( ServletContext servletContext )
    {
        this.servletContext = servletContext;
    }

}
