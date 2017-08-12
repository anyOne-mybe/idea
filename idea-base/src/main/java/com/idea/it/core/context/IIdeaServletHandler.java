
package com.idea.it.core.context;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月12日 新建
 */
public interface IIdeaServletHandler
{
    void handleRequest( HttpServletRequest request,
            HttpServletResponse response, String appName ) throws IOException;
}
