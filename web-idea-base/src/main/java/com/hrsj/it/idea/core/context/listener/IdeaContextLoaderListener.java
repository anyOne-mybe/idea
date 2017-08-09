
package com.hrsj.it.idea.core.context.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.hrsj.it.idea.core.context.manager.IdeaContextManager;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月8日 新建
 */
public class IdeaContextLoaderListener extends ContextLoaderListener
{
    @Override
    public void contextInitialized( ServletContextEvent event )
    {

        ServletContext servletContext = event.getServletContext();

        super.initWebApplicationContext( servletContext );

        initIdeaContext( servletContext );
    }

    @Override
    public void contextDestroyed( ServletContextEvent event )
    {
        super.contextDestroyed( event );
    }

    private void initIdeaContext( ServletContext servletContext )
    {
        IdeaContextManager.setServletContext( servletContext );
    }

}
