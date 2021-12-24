//package io.renren.config;
//
//import io.swagger.annotations.ApiOperation;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.SecurityScheme;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 旧：
// * http://localhost:8009/api/iStudy/swagger-ui.html
// * 新：
// * http://localhost:8009/api/iStudy/swagger-ui/index.html
// */
//@Configuration
//@EnableOpenApi
//public class Swagger3Config implements WebMvcConfigurer {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.OAS_30)
//            .apiInfo(apiInfo())
//            .select()
//            //加了ApiOperation注解的类，才生成接口文档
//            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//            //包下的类，才生成接口文档
//            //.apis(RequestHandlerSelectors.basePackage("io.renren.controller"))
//            .paths(PathSelectors.any())
//            .build()
//            .securitySchemes(security());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//            .title("工单管理系统")
//            .description("工单管理系统接口文档")
//            //.termsOfServiceUrl("https://www.renren.io")
//            .version("1.0.0")
//            .build();
//    }
//
//    private List<SecurityScheme> security() {
//        List<SecurityScheme> apiKeyList = new ArrayList();
//        apiKeyList.add(new ApiKey("token", "token", "header"));
//        return apiKeyList;
//    }
//
//}