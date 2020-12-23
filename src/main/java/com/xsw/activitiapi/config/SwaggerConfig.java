package com.xsw.activitiapi.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 *
 * @author xueshengwen
 * @since 2020/12/18 15:58
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                // 这里采用包含注解的方式来确定要显示的接口
                // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.any())
                // 这里采用包扫描的方式来确定要显示的接口
                // .apis(RequestHandlerSelectors.basePackage("com.xsw.activitiapi.controller"))
                // 错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                // 对根下所有路径进行监控
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("Activity Api Doc")
                // 描述
                .description("Activity Api Doc")
                // 条款地址（不可见）
                .termsOfServiceUrl("http://www.baidu.com")
                // 作者信息
                .contact("xue-sheng-wen")
                // 版本号
                .version("1.0")
                .build();
    }
}
