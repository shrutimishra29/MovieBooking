package com.moviebooking.userservice.exceptionhandler;


import com.moviebooking.userservice.constants.Constants;
import com.moviebooking.userservice.payload.ApiResponse;
import io.jsonwebtoken.JwtException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFound(ResourceNotFoundException resourceNotFoundException){
        String message = resourceNotFoundException.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validationFailed(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String, String> errors = new HashMap<>();

        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<Map<String,Object>> expiredJwtToken(JwtException jwtException){
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.message, jwtException.getMessage());
        map.put(Constants.success, false);
        map.put(Constants.status, HttpStatus.UNAUTHORIZED);
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String,Object>> constraintViolation(ConstraintViolationException constraintViolationException) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.message, constraintViolationException.getMessage());
        map.put(Constants.success, false);
        map.put(Constants.status, HttpStatus.BAD_REQUEST);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }
}
