package com.example.CurrencyConverterSb.controller;

import com.example.CurrencyConverterSb.Entity.ExchangeRates;
import com.example.CurrencyConverterSb.requests.UserRequest;
import com.example.CurrencyConverterSb.response.UserResponse;
import com.example.CurrencyConverterSb.service.ConverterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Rates")
public class  currencyConverter {
    @Autowired
    private ConverterServices converterServices;
    @GetMapping("/getAll")
    public ResponseEntity<List<ExchangeRates>> getAllCurrency(){
        List<ExchangeRates> exchangeRates = converterServices.getAllExchangeRates();
        return ResponseEntity.ok(exchangeRates);
    }
    @PostMapping("/add")
    public ResponseEntity<ExchangeRates>addCurrency(@RequestBody ExchangeRates x){
        //It will return the added object as a response
        return ResponseEntity.ok(converterServices.addAllExchangeRates(x));
    }
    @GetMapping("/getRates/{id}")
    public ResponseEntity<Object> getAllCurrencyById(@PathVariable String id){
        return ResponseEntity.ok(converterServices.getCurrencyById(id));
    }
    @GetMapping("/convert")
    public ResponseEntity<UserResponse> getConversion(@RequestBody UserRequest userRequest){
        return  ResponseEntity.ok(converterServices.getConversion(userRequest));
    }

}