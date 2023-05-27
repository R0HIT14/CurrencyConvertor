package com.example.CurrencyConverterSb.service;

import com.example.CurrencyConverterSb.CustomException.ApiRequestException;
import com.example.CurrencyConverterSb.Entity.ExchangeRates;
import com.example.CurrencyConverterSb.repository.ConvertorRepository;
import com.example.CurrencyConverterSb.requests.UserRequest;

import com.example.CurrencyConverterSb.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConverterServices {

    @Autowired
    private ConvertorRepository convertorRepository;
    private ExchangeRates exchangeRates;

    public List<ExchangeRates> getAllExchangeRates() {
        return convertorRepository.findAll();
    }

    public ExchangeRates addAllExchangeRates(ExchangeRates exchangeRates) {
        return convertorRepository.save(exchangeRates);
    }

    public ResponseEntity<Object> getCurrencyById(String id){
        ExchangeRates er = getAllExchangeRates().stream()
                .filter(t -> id.equals(t.getCurrencyId()))
                .findFirst()
                .orElse(null);
        if (er == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(er);
    }

    public UserResponse getConversion(UserRequest userRequest) {
        UserResponse r1=new UserResponse();
        r1.setConversion(convert(userRequest));
        return r1;
    }
    public ResponseEntity<Object> convert(UserRequest userRequest)throws ApiRequestException {
        ExchangeRates exchangeRates = getAllExchangeRates().stream()
                .filter(t -> userRequest.getCurType().equals(t.getCurrencyId()))
                .findFirst().orElse(null);

        if (exchangeRates == null) {
            throw new ApiRequestException("You have entered wrong currency type");
        }
        double rate = getExchangeRate(userRequest.getCur(), exchangeRates);

        if(rate == 0) {
            throw new ApiRequestException("Currency not found ");
        }
        return ResponseEntity.ok("Your Converted currency from "
                +userRequest.getCurType()+" to "+userRequest.getCur()
                +" = "+rate*userRequest.getAmount());
    }
    private double getExchangeRate(String currencyId, ExchangeRates er) {
        switch(currencyId) {
            case "INR": return er.getInrRate();
            case "USD": return er.getUsdRate();
            case "YEN": return er.getJpyRate();
            case "EURO": return er.getEurRate();
            default: return 0;
        }
    }
}