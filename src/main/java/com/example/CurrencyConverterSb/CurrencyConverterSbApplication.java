package com.example.CurrencyConverterSb;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Currency Convertor",version = "1.0",
		description = "Currency Convertor Springboot Application"))

public class CurrencyConverterSbApplication {
	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterSbApplication.class, args);
	}

}
