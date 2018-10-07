package com.frank.boot.config.cxf;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.soap.SOAPException;

import java.util.List;

import static org.apache.cxf.phase.Phase.INVOKE;

@Component(value = "securityInterceptor")
public class SecurityInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
    Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);

    public static final String xml_namespaceUR_att = "http://qd.tcco.com//authentication";
    public static final String xml_header_el = "soapenv:Header";
    public static final String xml_authentication_el = "auth:authentication";
    public static final String xml_systemID_el = "auth:systemID";
    public static final String xml_userID_el = "auth:userID";
    public static final String xml_password_el = "auth:password";

    // 什么时候触发拦截
    public SecurityInterceptor() {
        super(INVOKE);
    }

    /**
     *    <soapenv:Header>
     * 	<auth:authentication xmlns:auth="http://qd.tcco.com//authentication">
     * 		<auth:systemID>1</auth:systemID>
     * 		<auth:userID>test</auth:userID>
     * 		<auth:password>1test</auth:password>
     * 	</auth:authentication>
     *    </soapenv:Header>
     *  可校验系统id 系统是否允许调用
     *
     * @param message
     * @throws Fault
     */
    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        logger.info("==================SoapMessage =" + message);
        // 获取SOAP消息的全部头
        List<Header> headers = message.getHeaders();

        if (null == headers || headers.size() < 1) {
            throw new Fault(new SOAPException("SOAP消息头格式不对！"));
        }
        for (Header header : headers) {
            SoapHeader soapHeader = (SoapHeader) header;
            // 取出SOAP的Header元素
            Element element = (Element) soapHeader.getObject();
            logger.info("ELEMENT =" + element.toString());
            NodeList userIdNodes = element
                    .getElementsByTagName(xml_userID_el);
            NodeList pwdNodes = element
                    .getElementsByTagName(xml_password_el);
            NodeList systemIdNodes = element
                    .getElementsByTagName(xml_systemID_el);
            logger.info("############ 打印帐号信息 ##############");
            logger.info(userIdNodes.item(0) + "="
                    + userIdNodes.item(0).getTextContent());
            logger.info(systemIdNodes.item(0) + "="
                    + systemIdNodes.item(0).getTextContent());
            logger.info(pwdNodes.item(0) + "="
                    + pwdNodes.item(0).getTextContent());
            logger.info("############————————##############");
            if (null != userIdNodes && userIdNodes.item(0).getTextContent().equals("test") ) {
                if (null != pwdNodes && pwdNodes.item(0).getTextContent().equals("test")) {
                    logger.info("$$$$$$$$ 认证成功");
                } else {//认证失败则抛出异常，停止继续操作
                    SOAPException soapExc = new SOAPException("用户身份校验失败！");
                    throw new Fault(soapExc);
                }
            } else {//认证失败则抛出异常，停止继续操作
                SOAPException soapExc = new SOAPException("用户身份校验失败！");
                throw new Fault(soapExc);
            }

        }
    }
}
