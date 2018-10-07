package com.frank.boot.config.cxf;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.Ordered;

@Configuration
@ImportResource("classpath:webservices/webservice.xml")
public class CXFConfig {
    /**
     * 注册cxf webservice的上下文
     * @return
     */
    @Value("${cxfservlet}")
    String cxfServlet;
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new CXFServlet(), cxfServlet);
        bean.setLoadOnStartup(0);
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
