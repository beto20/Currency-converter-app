package com.alberto.currency.converter.app.service.api;

import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseApiDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exchangeRate", url = "https://api.apilayer.com/exchangerates_data")
public interface ExchangeRateClient {

    @GetMapping("/convert")
    CurrencyResponseApiDto exchange(@RequestHeader(value = "apikey", defaultValue = "7cxX3vT7HWv3nce8KzhHz1uI4e8OKpJf") String apikey,
                                    @RequestParam("to") String to,
                                    @RequestParam("from") String from,
                                    @RequestParam("amount") Float amount);
}
