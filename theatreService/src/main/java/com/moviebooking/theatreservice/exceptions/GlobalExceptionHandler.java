package com.moviebooking.theatreservice.exceptions;

import com.moviebooking.theatreservice.responses.ExceptionResponse;
import io.jsonwebtoken.JwtException;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.ForbiddenException;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ExceptionResponse notFoundHandler(ResourceNotFoundException foundException){
        return ExceptionResponse.builder().message(foundException.getMessage())
                .status(HttpStatus.NOT_FOUND).success(false).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponse validationFailed(MethodArgumentNotValidException methodArgumentNotValidException){

        return ExceptionResponse.builder().message(methodArgumentNotValidException.getMessage())
                .status(HttpStatus.NOT_FOUND).success(false).build();
    }

    @ExceptionHandler(JwtException.class)
    public ExceptionResponse expiredJwtToken(JwtException jwtException){
        return ExceptionResponse.builder().message(jwtException.getMessage())
                .status(HttpStatus.NOT_FOUND).success(false).build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ExceptionResponse constratintVolation(ConstraintViolationException constraintViolationException){
        return ExceptionResponse.builder().message(constraintViolationException.getMessage())
                .status(HttpStatus.NOT_FOUND).success(false).build();
    }

    @ExceptionHandler(ForbiddenException.class)
    public ExceptionResponse unauthorizedException(ForbiddenException exception){
        return ExceptionResponse.builder().message(exception.getMessage())
                .status(HttpStatus.UNAUTHORIZED).success(false).build();
    }
}
