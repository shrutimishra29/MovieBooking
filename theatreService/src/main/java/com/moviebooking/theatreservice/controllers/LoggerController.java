package com.moviebooking.theatreservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {

    Logger logger = LoggerFactory.getLogger(LoggerController.class);
    @RequestMapping("/home")
    @Operation(
            description = "Trial for logger.",
            responses = {
                    @ApiResponse(responseCode = "400",description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized access"),
                    @ApiResponse(responseCode = "200", description = "Successful Operation"),
                    @ApiResponse(responseCode = "500",description = "Server Error")
            }
    )
    public String home(){
        logger.trace("Error Happened !!");
        return "Hello from Spring boot";
    }
}
