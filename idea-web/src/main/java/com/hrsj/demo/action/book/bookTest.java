
package com.hrsj.demo.action.book;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月17日 新建
 */
public class bookTest
{

    public static void main( String[] args ) throws Exception
    {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf
                .createClient( "http://localhost:8080/book?wsdl" );

        Map<String, Object> props = new HashMap<String, Object>();
        props.put( WSHandlerConstants.ACTION,
                WSHandlerConstants.USERNAME_TOKEN );
        props.put( WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT );
        props.put( WSHandlerConstants.USER, "UserName" );
        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor( props );
        client.getOutInterceptors().add( wssOut );

        // 为接口中定义的方法名称 张三为传递的参数 返回一个Object数组
        Object[] objects = client.invoke( "queryBookByName", "张三" );
        // 输出调用结果

        Object value = objects[0];

        Book book = new Book();
        BeanUtils.copyProperties( book, value );

        System.out.println( book.getAuthor() );
    }

    void piblish()
    {
        BookAction action = new BookAction();
        String address = "http://localhost:8080/book";
        Endpoint.publish( address, action );
    }
}
