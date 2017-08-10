
package com.hrsj.it.idea.core.upload.support;

import java.io.IOException;
import java.util.List;

import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hrsj.it.idea.core.upload.IFileUploadHandler;
import com.hrsj.it.idea.core.upload.IdeaFileUpload;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月4日 新建
 */

@Named
public class FileUploadFactory implements IdeaFileUpload
{

    @Override
    public void execute( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
    {
        String uploadService = request.getParameter( "uploadService" );
        ServletContext context = request.getSession().getServletContext();
        WebApplicationContext application = WebApplicationContextUtils
                .getRequiredWebApplicationContext( context );

        IFileUploadHandler uploadHandler = (IFileUploadHandler)application
                .getBean( uploadService );

        // 1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload( factory );
        // 解决上传文件名的中文乱码
        upload.setHeaderEncoding( "UTF-8" );

        uploadHandler.configFileUpload( factory, upload );

        try
        {
            List<FileItem> fileItems = upload.parseRequest( request );
            uploadHandler.handle( fileItems );
        } catch ( FileUploadException e )
        {
            e.printStackTrace();
        }
    }

}
