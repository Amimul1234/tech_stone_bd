package com.techstone.tech_stone_bd_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @Author Amimul Ehsan
 * @Created at 11/6/21
 * @Project tech_stone_bd_project
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.techstone.tech_stone_bd_project"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Tech Stone  Assignment APIs",
                "Assignment Apis for Tech Stone",
                "1.0",
                "https://www.techstonebd.com/",
                new Contact("Tech Stone Bd", "https://www.techstonebd.com/", "techstonebd@gmail.com"),
                "API License",
                "https://www.techstonebd.com/",
                Collections.emptyList()
        );
    }
}
