package com.example.CurrencyConverterSb.service;

import gitcom.example.CurrencyConverterSb.CustomException.ApiRequestException;
import com.example.CurrencyConverterSb.Entity.ExchangeRates;
import com.example.CurrencyConverterSb.repository.RatesMapper;
import com.example.CurrencyConverterSb.requests.UserRequest;
import com.example.CurrencyConverterSb.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvertorServices {
    @Autowired
    public RatesMapper ratesMapper;

    public List<ExchangeRates> getAllExchangeRates() {
        return ratesMapper.findAll();
    }

    public ExchangeRates getCurrencyById(String id){
        return ratesMapper.getCurrencyById(id);
    }

    public ResponseEntity<String> addAllExchangeRates(ExchangeRates x) {
//        System.out.println(x.getCurrencyId());
//        System.out.println(ratesMapper.getCurrencyById(x.getCurrencyId()));
        ExchangeRates er = ratesMapper.getCurrencyById(x.getCurrencyId());
        if (er != null) {
            return ResponseEntity.badRequest().body("These exchange rates are already present in the database");
        }
        ratesMapper.addAllExchangeRates(x);
        return ResponseEntity.ok().body("Successfully added");
    }

    public UserResponse getConversion(UserRequest userRequest) {
        UserResponse r1=new UserResponse();
        r1.setConversion(convert(userRequest));
        return r1;
    }
    public ResponseEntity<Object> convert(UserRequest userRequest)throws ApiRequestException {
        ExchangeRates exchangeRates = ratesMapper.getCurrencyById(userRequest.getCurType());

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
