package com.rayclould.anonymousarea.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */
@Configuration
@ComponentScan("com.rayclould")
@EntityScan("com.rayclould.anonymousarea.*.model")
@RestController
@EnableSwagger2
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class AnonymousAreaWebMain {
    public static void main(String[] args) {
        SpringApplication.run(AnonymousAreaWebMain.class,args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiIgnore()
    @ApiOperation(value = "重定向到api首页")
    public ModelAndView index(){
        return new ModelAndView("redirect:/swagger-ui.html");
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.rayclould.anonymousarea.web"))
        .paths(PathSelectors.any())
        .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("匿名区 APIs")
                .description("Spring Boot 中使用 Swagger2 构建 RESTful APIs")
                .termsOfServiceUrl("https://anonymer.cn")
                .contact("南城")
                .version("1.0")
                .build();
    }
}