
package com.idea.it.core.menue;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月11日 新建
 */
public interface IMenueOperatable
{

    void handleIdeaMenue( HttpServletRequest request,
            HttpServletResponse response, String appName ) throws IOException;
}
