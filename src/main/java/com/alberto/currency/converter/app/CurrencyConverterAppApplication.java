package com.alberto.currency.converter.app;

import com.alberto.currency.converter.app.service.api.ExchangeRateClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = {ExchangeRateClient.class})
public class CurrencyConverterAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConverterAppApplication.class, args);
    }
}
