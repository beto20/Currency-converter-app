package com.alberto.currency.converter.app.controller;

import com.alberto.currency.converter.app.facade.CurrencyFacade;
import com.alberto.currency.converter.app.model.dto.request.CurrencyConverterRequestWebDto;
import com.alberto.currency.converter.app.model.dto.request.CurrencyRequestWebDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyConverterResponseWebDto;
import com.alberto.currency.converter.app.model.dto.response.CurrencyResponseWebDto;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
            summary = "01.01. Operacion de conversion de moneda",
            description = "Realiza la conversion de un monto ingresado a un tipo de cambio indicado"
    )
    @PostMapping
    public CurrencyResponseWebDto currencyConverter(@Valid @RequestBody CurrencyRequestWebDto currencyRequestWebDto) throws Throwable {
        return currencyFacade.converter(currencyRequestWebDto);
    }

    @Operation(
            summary = "01.02. Operacion de actualizacion de tipo de cambio",
            description = "Actualiza el valor de un tipo de cambio"
    )
    @PostMapping("/update-value")
    public CurrencyConverterResponseWebDto updateConverterValue(@Valid @RequestBody CurrencyConverterRequestWebDto currencyConverterRequestWebDto) {
        return currencyFacade.updateConverterValue(currencyConverterRequestWebDto);
    }
}
