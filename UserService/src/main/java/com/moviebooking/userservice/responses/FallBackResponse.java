package com.moviebooking.userservice.responses;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FallBackResponse {

    private String message;

    private HttpStatus errorCode;

    private boolean success;


}
