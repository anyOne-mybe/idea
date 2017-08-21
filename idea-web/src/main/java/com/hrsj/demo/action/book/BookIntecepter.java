
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

        // 添加登陆token
        addUserTokenHeader( message );

        // 添加SoapHeader内容
        SoapHeader header = new SoapHeader( qName, root );
        message.getHeaders().add( header );

    }

    private void addUserTokenHeader( SoapMessage message )
    {

        QName qName = new QName( "wsse:Security" );

        Document doc = DOMUtils.createDocument();
        // 验证用户名
        Element userNameToken = doc.createElement( "wsse:UsernameToken" );
        userNameToken.setAttribute( "wsu:Id",
                "UsernameToken-DC9443B36DD2FA9A5B15032799807651" );

        Element userName = doc.createElement( "wsse:Username" );
        userName.setTextContent( "MJZYADMIN" );
        userNameToken.appendChild( userName );

        Element password = doc.createElement( "wsse:Password" );
        password.setAttribute( "Type",
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText" );
        password.setTextContent( "2356ku2398" );
        userNameToken.appendChild( password );

        Element nonce = doc.createElement( "wsse:Nonce" );
        nonce.setAttribute( "EncodingType",
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary" );
        nonce.setTextContent( "dbU8RbOSzxj20t4vH69IBg==" );
        userNameToken.appendChild( nonce );

        Element created = doc.createElement( "wsse:Created" );
        created.setTextContent( "2017-08-21T01:46:20.764Z" );
        userNameToken.appendChild( created );

        Element root = doc.createElementNS(
                "xmlns:wsse=http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
                "wsse:Security" );
        root.setAttribute( "xmlns:wsu",
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" );

        root.setAttribute( "soapenv:mustUnderstand", "1" );

        root.appendChild( userNameToken );

        SoapHeader header = new SoapHeader( qName, root );
        message.getHeaders().add( header );
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
