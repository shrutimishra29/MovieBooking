package com.moviebooking.userservice.config;

import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@OpenAPI30
public class SwaggerConfiguration {

    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo())
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo getInfo() {
        return new ApiInfo("Theatre Service", "This is one of the microservice I developed for Movie Ticket Booking System","1.0","TERMS OF SERVICE",
                new Contact("Shruti Mishra", "", "shruti_mishra@persistent.com"),"LICENSES OF APIS","",Collections.emptyList() );
    }
}
