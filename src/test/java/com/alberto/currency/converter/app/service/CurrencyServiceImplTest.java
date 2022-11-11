package com.alberto.currency.converter.app.service;

import com.alberto.currency.converter.app.entity.CurrencyEntity;
import com.alberto.currency.converter.app.model.dto.CurrencyDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyConverterResponseDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseApiDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseDto;
import com.alberto.currency.converter.app.repository.CurrencyRepository;
import com.alberto.currency.converter.app.service.api.ExchangeRateClient;
import com.alberto.currency.converter.app.service.impl.CurrencyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CurrencyServiceImplTest {

    private CurrencyRepository currencyRepository;
    private ExchangeRateClient exchangeRate;
    private CurrencyServiceImpl currencyService;

    @BeforeEach
    public void setUp() {
        currencyRepository = Mockito.mock(CurrencyRepository.class);
        exchangeRate = Mockito.mock(ExchangeRateClient.class);
        this.currencyService = new CurrencyServiceImpl(exchangeRate, currencyRepository);
    }

    @Test
    void converter_thenOk() throws Throwable {
        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setTypeOrigin("PEN");
        currencyEntity.setTypeDestiny("PEN");
        currencyEntity.setRateDestiny(100.00F);

        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setAmount(100.00F);
        currencyDto.setCurrencyOrigin("PEN");
        currencyDto.setCurrencyDestiny("USD");

        CurrencyResponseApiDto currencyResponseApiDto = new CurrencyResponseApiDto();
        currencyResponseApiDto.setDate("10/11/2022");
        currencyResponseApiDto.setResult(100.00F);
        currencyResponseApiDto.setSuccess("USD");

        Mockito.when(currencyRepository.findCurrencyEntityByTypeDestinyAndTypeOrigin(Mockito.any(), Mockito.any()))
                .thenReturn(currencyEntity);

        Mockito.when(exchangeRate.exchange(Mockito.any(), Mockito.anyString(), Mockito.anyString(), Mockito.any()))
                .thenReturn(currencyResponseApiDto);

        Mockito.when(currencyRepository.save(Mockito.any()))
                .thenAnswer(i -> i.getArguments()[0]);

        CurrencyResponseDto response = currencyService.converter(currencyDto);
        Assertions.assertNotNull(response);
    }

    @Test
    void updateConverterValue_thenOk() {

        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setTypeOrigin("PEN");
        currencyEntity.setTypeDestiny("PEN");
        currencyEntity.setRateDestiny(100.00F);

        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setAmount(100.00F);
        currencyDto.setCurrencyOrigin("PEN");
        currencyDto.setCurrencyDestiny("USD");

        Mockito.when(currencyRepository.findCurrencyEntityByTypeOrigin(Mockito.any()))
                .thenReturn(currencyEntity);

        Mockito.when(currencyRepository.save(Mockito.any()))
                .thenAnswer(i -> i.getArguments()[0]);

        CurrencyConverterResponseDto response = currencyService.updateConverterValue(currencyDto);
        Assertions.assertNotNull(response);
    }

}
