package com.example.CurrencyConverterSb.repository;

import com.example.CurrencyConverterSb.CustomException.ApiRequestException;
import com.example.CurrencyConverterSb.Entity.ExchangeRates;
import com.example.CurrencyConverterSb.requests.UserRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface RatesMapper {
    @Select("Select * from exchange_rates")
    @Results({
            @Result(property = "currencyId", column = "Currency"),
            @Result(property = "inrRate", column = "INR"),
            @Result(property = "eurRate", column = "EURO"),
            @Result(property = "jpyRate", column = "YEN"),
            @Result(property = "usdRate", column = "USD")
    })
    List<ExchangeRates> findAll();

    @Select("Select * from exchange_rates where Currency = #{id}")
    @Results({
            @Result(property = "currencyId", column = "Currency"),
            @Result(property = "inrRate", column = "INR"),
            @Result(property = "eurRate", column = "EURO"),
            @Result(property = "jpyRate", column = "YEN"),
            @Result(property = "usdRate", column = "USD")
    })
    ExchangeRates getCurrencyById(String id);

    @Insert("INSERT INTO exchange_rates (Currency, INR, EURO, YEN, USD) " +
            " VALUES (#{currencyId}, #{inrRate}, #{eurRate}, #{jpyRate}, #{usdRate})")
    int addAllExchangeRates(ExchangeRates er);

    @Select("Select #{cur} from exchange_rates where Currency = #{curType}")
    String getConversion(String cur, String curType);
}
