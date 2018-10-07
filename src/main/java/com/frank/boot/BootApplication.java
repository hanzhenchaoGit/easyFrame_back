package com.frank.boot;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.wwjd.starter.canal.annotation.EnableCanalClient;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// 排除druid自动查找配置
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class,SecurityAutoConfiguration.class} )
//@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.frank.boot.dao")
//@EnableCanalClient
public class BootApplication extends SpringBootServletInitializer {
    public static void main(String [] args){
        SpringApplication.run(BootApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(BootApplication.class);
    }
}

/**
 * 使用内置tomcat
 */
//public class BootApplication {
//    public static void main(String [] args){
//        SpringApplication.run(BootApplication.class, args);
//    }
//}
//删除pom中的tomcat引用
