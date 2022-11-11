package com.alberto.currency.converter.app.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public class CurrencyConverterResponseWebDto implements Serializable {

    private static final long serialVersionUID = 7821843697794351765L;

    @Schema(description = "Resultado", example = "Tipo de cambio actualizado")
    private String message;

    public CurrencyConverterResponseWebDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
