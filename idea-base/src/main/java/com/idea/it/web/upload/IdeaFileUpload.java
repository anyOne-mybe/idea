
package com.idea.it.web.upload;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月8日 新建
 */
public interface IdeaFileUpload
{
    void execute( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException;
}
