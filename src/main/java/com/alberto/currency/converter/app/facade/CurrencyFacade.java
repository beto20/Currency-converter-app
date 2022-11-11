package com.alberto.currency.converter.app.facade;

import com.alberto.currency.converter.app.model.dto.request.CurrencyConverterRequestWebDto;
import com.alberto.currency.converter.app.model.dto.request.CurrencyRequestWebDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyConverterResponseWebDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseWebDto;
import com.alberto.currency.converter.app.model.mapper.CurrencyMapper;
import com.alberto.currency.converter.app.service.CurrencyService;
import org.springframework.stereotype.Component;

@Component
public class CurrencyFacade {

    private final CurrencyService currencyService;

    public CurrencyFacade(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }


    public CurrencyResponseWebDto converter(CurrencyRequestWebDto currencyRequestWebDto) throws Throwable {
        var currencyDto = CurrencyMapper.MAPPER.toDto(currencyRequestWebDto) ;
        return CurrencyMapper.MAPPER.toWebDtoResponse(currencyService.converter(currencyDto));
    }
    public CurrencyConverterResponseWebDto updateConverterValue(CurrencyConverterRequestWebDto currencyConverterRequestWebDto) {
        var currencyDto = CurrencyMapper.MAPPER.toDtoFromConverter(currencyConverterRequestWebDto) ;
        return CurrencyMapper.MAPPER.toWebDtoConverterResponse(currencyService.updateConverterValue(currencyDto));
    }

}
