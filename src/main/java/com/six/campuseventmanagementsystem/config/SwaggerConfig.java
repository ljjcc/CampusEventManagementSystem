//package com.six.campuseventmanagementsystem.config;
//
//
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2//启动Swagger2功能
//public class SwaggerConfig {
//
//    private Contact contact = new Contact("Six","localhost:8080/swagger-ui.html", "202010098055@qq.com");
//
//    @Bean
//    public Docket createRestApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com"))//com包下所有API都交给Swagger2管理
//                .paths(PathSelectors.any()).build();
//    }
//
//    /**
//     * 此处主要是API文档页面显示信息
//     */
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("校园活动赛事管理系统项目API")//标题
//                .description("校园活动赛事管理系统项目")//描述
//                .version("1.0")//版本
//                .contact(contact)
//                .build();
//    }
//
//}



package com.six.campuseventmanagementsystem.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Date;
import static springfox.documentation.builders.PathSelectors.regex;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //定义API接口映射路径
    public static final String DEFAULT_INCLUDE_PATTERN = "/CEMS/.*";
    private final Logger log =
            LoggerFactory.getLogger(SwaggerConfig.class);
    @Bean
    public Docket swaggerSpringfoxDocket() {
        log.debug("Starting Swagger");
        StopWatch watch = new StopWatch();
        watch.start();
        //用于生成对应API接口文档的描述信息，可省略
        ApiInfo apiInfo = new ApiInfo("校园赛事活动管理系统API接口测试文档","校园活动赛事管理系统项目",
                "1.0","contact","version","","");
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .genericModelSubstitutes(ResponseEntity.class)
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .directModelSubstitute(java.time.LocalDate.class, String.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .select()
                .paths(regex(DEFAULT_INCLUDE_PATTERN))//匹配路径生成对应接口文档
                .build();
        watch.stop();
        log.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
        return docket;
    }
}
