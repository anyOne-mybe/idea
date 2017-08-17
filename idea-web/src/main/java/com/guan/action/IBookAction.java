
package com.guan.action;

import javax.jws.WebService;

import com.hrsj.demo.action.book.Book;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月17日 新建
 */
@WebService
public interface IBookAction
{

    Book queryBookByName( String string );

}
