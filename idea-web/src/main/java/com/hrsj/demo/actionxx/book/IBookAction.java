
package com.hrsj.demo.actionxx.book;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.hrsj.demo.action.book.Book;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月17日 新建
 */
@WebService( serviceName = "IBookActionxxx", targetNamespace = "action.guan.com" )
public interface IBookAction
{
    Book queryBookByName( @WebParam( name = "bookName" ) String name );
}
