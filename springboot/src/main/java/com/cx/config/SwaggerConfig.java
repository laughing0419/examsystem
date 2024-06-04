package com.cx.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2  //启用swagger2   //springboot版本 ---2.5.6
public class SwaggerConfig {

    @Bean//配置Swageer的Docket的bean示例
    public Docket getDocket(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("zlh")//enable(false)是否启动swagger，如果为false则swagger不能启动
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cx.controller"))
                //path过滤一个路径
                .build()
                ;
    }
    //配置swagger信息 =apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("laughing", "http://www.baidu.com/", "1936018865@qq.com");

        return new ApiInfo(
                "超星考试系统文档",
                "超星考试系统",
                "1.0",
                "http://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
