package com.example.CurrencyConverterSb.repository;

import com.example.CurrencyConverterSb.Entity.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvertorRepository extends JpaRepository<ExchangeRates,Long> {
}
