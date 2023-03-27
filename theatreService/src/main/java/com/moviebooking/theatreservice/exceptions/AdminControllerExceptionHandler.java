package com.moviebooking.theatreservice.exceptions;

import com.moviebooking.theatreservice.controllers.AdminController;
import com.moviebooking.theatreservice.responses.ExceptionResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = AdminController.class)
public class AdminControllerExceptionHandler {

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

    @ExceptionHandler(ConstraintViolationException.class)
    public ExceptionResponse constraintViolation(ConstraintViolationException constraintViolationException){
        return ExceptionResponse.builder().message(constraintViolationException.getMessage())
                .status(HttpStatus.NOT_FOUND).success(false).build();
    }
}
