package com.alberto.currency.converter.app.service.impl;

import com.alberto.currency.converter.app.entity.CurrencyEntity;
import com.alberto.currency.converter.app.model.dto.CurrencyDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyConverterResponseDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseDto;
import com.alberto.currency.converter.app.repository.CurrencyRepository;
import com.alberto.currency.converter.app.service.CurrencyService;
import com.alberto.currency.converter.app.service.api.ExchangeRateClient;
import org.springframework.stereotype.Service;


@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final ExchangeRateClient exchangeRate;

    public CurrencyServiceImpl(ExchangeRateClient exchangeRate, CurrencyRepository currencyRepository) {
        this.exchangeRate = exchangeRate;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public CurrencyResponseDto converter(CurrencyDto currencyDto) throws Throwable {

        CurrencyResponseDto currencyResponseDto = new CurrencyResponseDto();

        if (currencyDto ==  null || currencyDto.getCurrencyDestiny().isEmpty())
            return currencyResponseDto;

        var currencyFound = currencyRepository.findCurrencyEntityByTypeDestinyAndTypeOrigin(currencyDto.getCurrencyDestiny(), currencyDto.getCurrencyOrigin());

        if (currencyFound !=  null) {
            currencyResponseDto.setCurrencyOrigin(currencyDto.getCurrencyOrigin());
            currencyResponseDto.setAmount(currencyDto.getAmount());
            currencyResponseDto.setCurrencyDestiny(currencyFound.getTypeDestiny());
            currencyResponseDto.setCurrencyTypeAmount(currencyDto.getAmount() * currencyFound.getRateDestiny());
        } else {
            CurrencyEntity currencyEntity = new CurrencyEntity();

            try {
                var exchangeValue = exchangeRate.exchange("7cxX3vT7HWv3nce8KzhHz1uI4e8OKpJf",
                        currencyDto.getCurrencyDestiny(),
                        currencyDto.getCurrencyOrigin(),
                        currencyDto.getAmount());

                currencyResponseDto.setCurrencyOrigin(currencyDto.getCurrencyOrigin());
                currencyResponseDto.setAmount(currencyDto.getAmount());
                currencyResponseDto.setCurrencyDestiny(exchangeValue.getQuery().getTo());
                currencyResponseDto.setCurrencyTypeAmount(exchangeValue.getResult());

                currencyEntity.setTypeOrigin(exchangeValue.getQuery().getFrom());
                currencyEntity.setTypeDestiny(exchangeValue.getQuery().getTo());
                currencyEntity.setRateDestiny(exchangeValue.getInfo().getRate());
            } catch (Exception e) {
                throw e.getCause();
            }
            currencyRepository.save(currencyEntity);
        }
        return currencyResponseDto;
    }

    @Override
    public CurrencyConverterResponseDto updateConverterValue(CurrencyDto currencyDto) {
        String notFoundMessage = "Tipo de cambio no encontrado";
        CurrencyConverterResponseDto currencyConverterResponseDto = new CurrencyConverterResponseDto();
        currencyConverterResponseDto.setMessage(notFoundMessage);
        var currencyFound = currencyRepository.findCurrencyEntityByTypeOrigin(currencyDto.getCurrencyOrigin());
        if (currencyFound != null) {
            currencyFound.setRateDestiny(currencyDto.getAmount());
            currencyRepository.save(currencyFound);
            currencyConverterResponseDto.setMessage("Tipo de cambio actualizado");
        }
        return currencyConverterResponseDto;
    }
}
