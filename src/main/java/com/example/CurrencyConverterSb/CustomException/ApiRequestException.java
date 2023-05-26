package com.example.CurrencyConverterSb.CustomException;

public class ApiRequestException extends RuntimeException{
    public ApiRequestException(String message) {
        super(message);
    }

}
