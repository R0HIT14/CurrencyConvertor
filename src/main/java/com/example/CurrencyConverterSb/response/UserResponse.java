package com.example.CurrencyConverterSb.response;

import org.springframework.http.ResponseEntity;

public class UserResponse {
    ResponseEntity<Object> conversion;

    public UserResponse(){

    }
    public UserResponse(ResponseEntity<Object> conversion) {
        this.conversion = conversion;
    }

    public ResponseEntity<Object> getConversion() {
        return conversion;
    }

    public void setConversion(ResponseEntity<Object> conversion) {
        this.conversion = conversion;
    }
}
