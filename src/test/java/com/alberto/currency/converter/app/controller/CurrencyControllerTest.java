package com.alberto.currency.converter.app.controller;

import com.alberto.currency.converter.app.facade.CurrencyFacade;
import com.alberto.currency.converter.app.model.dto.response.CurrencyConverterResponseWebDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseWebDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

class CurrencyControllerTest {

    private CurrencyFacade currencyFacade;

    private static MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        currencyFacade = Mockito.mock(CurrencyFacade.class);
        CurrencyController currencyController = new CurrencyController(currencyFacade);

        mockMvc = MockMvcBuilders.standaloneSetup(currencyController)
                .setControllerAdvice(new ArrayList<>())
                .build();
    }

    @Test
    void currencyConverter_thenOk() throws Throwable {
        CurrencyResponseWebDto currencyResponseWebDto = new CurrencyResponseWebDto();
        currencyResponseWebDto.setAmount(100.00F);
        currencyResponseWebDto.setCurrencyTypeAmount(224.123F);
        currencyResponseWebDto.setCurrencyOrigin("EUR");
        currencyResponseWebDto.setCurrencyDestiny("USD");

        Mockito.when(currencyFacade.converter(Mockito.any()))
                .thenReturn(currencyResponseWebDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/currency")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"amount\":100.0,\"currencyTypeAmount\":224.123,\"currencyOrigin\":\"EUR\",\"currencyDestiny\":\"USD\"}")
        ).andReturn();

        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    void updateConverterValue_thenOk() throws Exception {

        CurrencyConverterResponseWebDto currencyConverterResponseWebDto = new CurrencyConverterResponseWebDto();
        currencyConverterResponseWebDto.setMessage("success");

        Mockito.when(currencyFacade.updateConverterValue(Mockito.any()))
                .thenReturn(currencyConverterResponseWebDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/currency/update-value")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\":\"success\"}")
        ).andReturn();

        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }
}
