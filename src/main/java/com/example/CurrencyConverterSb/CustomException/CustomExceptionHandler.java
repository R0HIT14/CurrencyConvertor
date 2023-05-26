package com.example.CurrencyConverterSb.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<ApiException> apiExceptionHandler(ApiRequestException e){
        ApiException apiException = new ApiException(e.getMessage(), e.getCause(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiException,HttpStatus.NOT_FOUND);
    }
}
