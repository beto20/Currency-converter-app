package com.alberto.currency.converter.app.facade;

import com.alberto.currency.converter.app.model.dto.request.CurrencyConverterRequestWebDto;
import com.alberto.currency.converter.app.model.dto.request.CurrencyRequestWebDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyConverterResponseDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyConverterResponseWebDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseWebDto;
import com.alberto.currency.converter.app.service.CurrencyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CurrencyFacadeTest {

    private CurrencyService currencyService;
    private CurrencyFacade currencyFacade;

    @BeforeEach
    public void setUp() {
        currencyService = Mockito.mock(CurrencyService.class);
        this.currencyFacade = new CurrencyFacade(currencyService);
    }

    @Test
    void converter_thenOk() throws Throwable {
        CurrencyResponseDto currencyResponseDto = new CurrencyResponseDto();
        currencyResponseDto.setAmount(10.00F);
        currencyResponseDto.setCurrencyOrigin("PEN");
        currencyResponseDto.setCurrencyTypeAmount(100.00F);
        currencyResponseDto.setCurrencyDestiny("USD");

        CurrencyRequestWebDto currencyRequestWebDto = new CurrencyRequestWebDto();
        currencyRequestWebDto.setAmount(10.00F);
        currencyRequestWebDto.setCurrencyOrigin("PEN");
        currencyRequestWebDto.setCurrencyDestiny("USD");

        Mockito.when(currencyService.converter(Mockito.any()))
                .thenReturn(currencyResponseDto);

        CurrencyResponseWebDto response = currencyFacade.converter(currencyRequestWebDto);
        Assertions.assertNotNull(response);
    }

    @Test
    void updateConverterValue_thenOk() {

        CurrencyConverterRequestWebDto currencyConverterRequestWebDto = new CurrencyConverterRequestWebDto();
        currencyConverterRequestWebDto.setRate(1.00F);
        currencyConverterRequestWebDto.setCurrencyType("PEN");

        CurrencyConverterResponseDto currencyConverterResponseDto = new CurrencyConverterResponseDto();
        currencyConverterResponseDto.setMessage("success");

        Mockito.when(currencyService.updateConverterValue(Mockito.any()))
                .thenReturn(currencyConverterResponseDto);

        CurrencyConverterResponseWebDto response = currencyFacade.updateConverterValue(currencyConverterRequestWebDto);
        Assertions.assertNotNull(response);
    }

}
