package com.moviebooking.theatreservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Theatre Service", version = "1.0",
		description = "This is one of the microservice I developed for Movie Ticket Booking System",termsOfService = "TERMS OF SERVICE"))
public class TheatreServiceApplication {


	public static void main(String[] args) {

		SpringApplication.run(TheatreServiceApplication.class, args);
	}


}
