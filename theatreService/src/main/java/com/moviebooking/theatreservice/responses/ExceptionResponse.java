package com.moviebooking.theatreservice.responses;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponse {

    public String message;
    public HttpStatus status;

    public Boolean success;
}
