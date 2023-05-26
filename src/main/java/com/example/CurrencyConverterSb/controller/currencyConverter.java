package com.example.CurrencyConverterSb.controller;

import com.example.CurrencyConverterSb.Entity.ExchangeRates;
import com.example.CurrencyConverterSb.requests.UserRequest;
import com.example.CurrencyConverterSb.response.UserResponse;
import com.example.CurrencyConverterSb.service.ConvertorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Rates")
public class currencyConverter {
    @Autowired
    ConvertorServices convertorServices;
    @GetMapping(value = "/get")
    public ResponseEntity<List<ExchangeRates>> getAllCurrency(){
        return ResponseEntity.ok(convertorServices.getAllExchangeRates());
    }
    @PostMapping("/add")
    public ResponseEntity<String> addCurrency(@RequestBody ExchangeRates x){
        return convertorServices.addAllExchangeRates(x);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ExchangeRates> getAllCurrencyById(@PathVariable String id){
        return ResponseEntity.ok(convertorServices.getCurrencyById(id));
    }
    @GetMapping("/convert")
    public ResponseEntity<UserResponse> getConversion(@RequestBody UserRequest userRequest){
        return  ResponseEntity.ok(convertorServices.getConversion(userRequest));
    }

}