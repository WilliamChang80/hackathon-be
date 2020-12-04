package com.hackathon.hackbe.config;

import com.hackathon.hackbe.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;

import java.util.Arrays;
import java.util.List;

public class SwaggerConfig {
    private static final String CONTROLLER_PATH = "com.hackathon.hackbe.controller";
    private static final String API_PATH = "/api/*";
    private static final String SWAGGER_TITLE = "Hackathon";

    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(SWAGGER_TITLE).build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_12)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PATH))
                .paths(PathSelectors.ant(API_PATH))
                .build()
                .apiInfo(apiInfo());
    }
}
