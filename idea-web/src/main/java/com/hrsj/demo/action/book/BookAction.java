
package com.hrsj.demo.action.book;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.xml.ws.Endpoint;

import com.hrsj.demo.actionxx.book.IBookAction;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月17日 新建
 */
@Named
public class BookAction implements IBookAction
{

    // @Override
    public Book queryBookByName( String name )
    {
        System.out.println( name );
        Book book = new Book();
        book.setAuthor( "x" );

        List<String> prices = new ArrayList<>();
        prices.add( "price1" );
        book.setPrices( prices );

        return book;
    }

    public static void main( String[] args )
    {
        BookAction action = new BookAction();
        String address = "http://localhost:8080/book";
        Endpoint.publish( address, action );
    }

}
