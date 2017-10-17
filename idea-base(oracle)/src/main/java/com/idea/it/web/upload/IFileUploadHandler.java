
package com.idea.it.web.upload;

import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传处理接口
 * 
 * @author guan
 */
public interface IFileUploadHandler
{

    void configFileUpload( DiskFileItemFactory factory,
            ServletFileUpload upload );

    void handle( List<FileItem> fileItems );

}
