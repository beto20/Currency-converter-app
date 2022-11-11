package com.alberto.currency.converter.app.controller;

import com.alberto.currency.converter.app.facade.CurrencyFacade;
import com.alberto.currency.converter.app.model.dto.request.CurrencyConverterRequestWebDto;
import com.alberto.currency.converter.app.model.dto.request.CurrencyRequestWebDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyConverterResponseWebDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseWebDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/currency")
public class CurrencyController {

    private final CurrencyFacade currencyFacade;

    public CurrencyController(CurrencyFacade currencyFacade) {
        this.currencyFacade = currencyFacade;
    }

    @PostMapping
    public CurrencyResponseWebDto currencyConverter(@RequestBody @Valid CurrencyRequestWebDto currencyRequestWebDto) throws Throwable {
        return currencyFacade.converter(currencyRequestWebDto);
    }

    @PostMapping("/update-value")
    public CurrencyConverterResponseWebDto updateConverterValue(@RequestBody @Valid CurrencyConverterRequestWebDto currencyConverterRequestWebDto) {
        return currencyFacade.updateConverterValue(currencyConverterRequestWebDto);
    }
}
