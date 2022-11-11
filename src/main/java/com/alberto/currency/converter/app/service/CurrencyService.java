package com.alberto.currency.converter.app.service;

import com.alberto.currency.converter.app.model.dto.CurrencyDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyConverterResponseDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseDto;

public interface CurrencyService {
    CurrencyResponseDto converter(CurrencyDto currencyDto) throws Throwable;
    CurrencyConverterResponseDto updateConverterValue(CurrencyDto currencyDto);
}
