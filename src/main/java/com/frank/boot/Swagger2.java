package com.frank.boot;


//swagger2的配置文件，在项目的启动类的同级文件建立

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2 {
    @Value("${system.swagger2.page.title:swagger2}")
    private String title;
    @Value("${system.swagger2.page.author:frank}")
    private String author;
    @Value("${system.swagger2.page.url:}")
    private String url;
    @Value("${system.swagger2.page.email:}")
    private String email;
    @Value("${system.swagger2.page.version:1.0}")
    private String version;
    @Value("${system.swagger2.page.description:swagger2 description}")
    private String description;

//swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage(
                        this.getClass().getName().replace(
                                this.getClass().getSimpleName(),"")+"controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title(title)
                //创建人
                .contact(new Contact(author, url, email))
                //版本号
                .version(version)
                //描述
                .description(description)
                .build();
    }
    public static void main(String []ar){
        Swagger2 swagger2 =new Swagger2();
        String className = swagger2.getClass().getSimpleName();
        System.out.println(swagger2.getClass().getName());
    }


}