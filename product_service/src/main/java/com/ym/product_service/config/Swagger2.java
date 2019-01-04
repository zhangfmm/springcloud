package com.ym.product_service.config;

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
 * Created by Administrator on 2017/6/6.
 * 在线文档配置
 * @author huangjj
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ym.product_service.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("我的项目 API v2 接口文档")
                .description("内网测试环境 base url：http://web.test.tlifang.cn:28888/api/v2\n" +
                        "\n" +
                        "\t*头部header的参数*\n" +
                        "\t1、Authorization\t\t用户token(ps:71d391fa04244cbf995b8cf1ca134ec5)\n" +
                        "\t2、platform\t\t\t平台（1：android 2：ios 3：web）\n" +
                        "\t3、version_no\t\t版本序号（ps：1）\n" +
                        "\t4、version\t\t\t版本号（ps：2.0.1）\n" +
                        "\t5、uuid\t\t\t\t手机唯一识别码")
//                .termsOfServiceUrl("http://blog.didispace.com/")
//                .contact("alevi")
                .version("2.0")
                .build();
    }
}
