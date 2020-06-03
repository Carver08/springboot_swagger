package com.ms.swagger.config;

import com.google.common.base.Predicates;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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

import java.util.ArrayList;

/**
 * @author ms_miao
 * @createTime 2020-06-03 15:40
 */
@Configuration
@EnableSwagger2     //开启Swagger2
@ConditionalOnProperty(prefix ="swagger2",value = {"enable"},havingValue = "true") //限制swagger在发布环境中使用
public class SwaggerConfig {

    //配置Swagger的docket的bean实例
    @Bean
    public Docket CreateRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)//false 表示关闭swagger   true表示启用swagger
                .groupName("测试1")
                .pathMapping("/")
                .select()
                //RequestHandlerSelectors配置要扫描接口的方式
                //basePackage():指定要扫描的包 basePackage("com.ms.swagger.controller")(推荐使用)
                //any():扫描全部  none:不扫描
                //withClassAnnotation():扫描类上的注解  参数是一个注解的反射对象
                //withMethodAnnotation():扫描方法上的注解
                .apis(RequestHandlerSelectors.any())
                //过滤路径
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    /**
     * 创建多个分组：创建多个Docket实例
     * @return
     */
    @Bean
    public Docket CreateRestApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("测试2");

    }
    @Bean
    public Docket CreateRestApi3() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("测试3");

    }


    //配置Swagger信息 apiInfo
    private ApiInfo apiInfo () {

        return new ApiInfo("这里是Swagger记录日志",
                "描述-swagger是一个很强大的工具",
                "V1.0",
                "http://localhost:8080",
                new Contact("XiaoMing", "http://www.xiaoming.com", "XiaoMing@163.com"),//作者信息
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }

}
