
package com.hrsj.demo.action.book;

import javax.inject.Named;
import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月18日 新建
 */
@Named
public class BookIntecepter extends AbstractSoapInterceptor
{

    public BookIntecepter()
    {
        super( Phase.WRITE );
    }

    public BookIntecepter( String p )
    {
        super( Phase.WRITE );
    }

    @Override
    public void handleMessage( SoapMessage message ) throws Fault
    {
        QName qName = new QName( "cux:SOAHeader" );

        Document doc = DOMUtils.createDocument();
        // 验证用户名
        Element responsibility = doc.createElement( "Responsibility" );
        responsibility.setTextContent( "CRC_B10_SJYM0_OM_ORDER_ZONGBU" );
        // 验证密码
        Element respApplication = doc.createElement( "RespApplication" );
        respApplication.setTextContent( "ONT" );

        Element securityGroup = doc.createElement( "SecurityGroup" );
        securityGroup.setTextContent( "" );
        // 验证密码
        Element nLSLanguage = doc.createElement( "NLSLanguage" );
        nLSLanguage.setTextContent( "" );

        Element org_Id = doc.createElement( "Org_Id" );
        org_Id.setTextContent( "" );

        Element root = doc.createElementNS(
                "http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_10_ws_item_pkg/",
                "cux:SOAHeader" );
        root.appendChild( responsibility );
        root.appendChild( respApplication );
        root.appendChild( securityGroup );
        root.appendChild( nLSLanguage );
        root.appendChild( org_Id );
        // 创建SoapHeader内容

        SoapHeader header = new SoapHeader( qName, root );
        // 添加SoapHeader内容
        // message.getHeaders().add( header );
    }

    private void aaa()
    {
        QName qName = new QName( "AuthorizationSoapHeader" );

        Document doc = DOMUtils.createDocument();
        // 验证用户名
        Element id = doc.createElement( "UserName" );
        id.setTextContent( "0001" );
        // 验证密码
        Element pwd = doc.createElement( "Password" );
        pwd.setTextContent( "123" );

        Element root = doc.createElementNS(
                "http://schemas.xmlsoap.org/soap/envelope/",
                "AuthorizationSoapHeader" );
        root.appendChild( id );
        root.appendChild( pwd );
        // 创建SoapHeader内容

        SoapHeader header = new SoapHeader( qName, root );
        // 添加SoapHeader内容

    }

}
