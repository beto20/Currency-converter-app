package com.alberto.currency.converter.app.model.mapper;

import com.alberto.currency.converter.app.model.dto.CurrencyDto;
import com.alberto.currency.converter.app.model.dto.request.CurrencyConverterRequestWebDto;
import com.alberto.currency.converter.app.model.dto.request.CurrencyRequestWebDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyConverterResponseDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyConverterResponseWebDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseWebDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CurrencyMapper {

    CurrencyMapper MAPPER = Mappers.getMapper(CurrencyMapper.class);

    CurrencyDto toDto(CurrencyRequestWebDto currencyRequestWebDto);
    CurrencyResponseWebDto toWebDtoResponse(CurrencyResponseDto currencyResponseDto);

    @Mapping(source = "rate", target = "amount")
    @Mapping(source = "currencyType", target = "currencyOrigin")
    CurrencyDto toDtoFromConverter(CurrencyConverterRequestWebDto currencyConverterRequestWebDto);

    CurrencyConverterResponseWebDto toWebDtoConverterResponse (CurrencyConverterResponseDto currencyConverterResponseDto);
}
