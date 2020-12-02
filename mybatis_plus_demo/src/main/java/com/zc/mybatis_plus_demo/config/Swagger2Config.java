package com.zc.mybatis_plus_demo.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2API文档的配置
 */
//@Profile({"dev"})
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
            .name("Authorization")
            .description("认证token")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(false)
            .build());

        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .globalOperationParameters(parameters)
            .select()
            //为当前包下controller生成API文档
            .apis(RequestHandlerSelectors.basePackage("com.zc.mybatis_plus_demo.controller"))
            //为有@Api注解的Controller生成API文档
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
            //为有@ApiOperation注解的方法生成API文档
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("mybatisplus测试接口演示")
            .description("mybatisplus")
            .contact("zc")
            .version("1.0")
            .build();
    }
}