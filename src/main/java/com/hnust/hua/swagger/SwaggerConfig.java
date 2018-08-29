package com.hnust.hua.swagger;

/**
 * Created by xhua on 2018-08-28.
 * Describe:
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration        //表示该类为配置类，让spring加载该类
@EnableSwagger2       //启用swagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())   //所有API
                .paths(PathSelectors.any())           //所有路径
                .build()
                .apiInfo(apiInfo());       //API信息
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("SpringMVC整合swagger").
                description("在这里你可以浏览项目所有接口,并提供相关测试工具").version("2.7.0").build();
    }

}