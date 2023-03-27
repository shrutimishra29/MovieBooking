package com.moviebooking.theatreservice.config;

import io.swagger.v3.oas.models.annotations.OpenAPI30;

import org.springdoc.core.configuration.SpringDocDataRestConfiguration;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Import;


@Configuration
@OpenAPI30
@Import(SpringDocDataRestConfiguration.class)
public class SwaggerConfiguration {

}
