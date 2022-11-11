package com.alberto.currency.converter.app.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CurrencyConverterRequestWebDto implements Serializable {

    private static final long serialVersionUID = 7821843697794351765L;

    @Schema(description = "Tipo de cambio", example = "USD")
    @Size(min = 2, max = 5)
    @NotBlank(message = "Debe ingresar el tipo de cambio")
    private String currencyType;
    @Schema(description = "Valor de tipo de cambio", example = "3.98")
    @DecimalMin(value = "0.1", message = "Debe ingresar un monto mayor a cero")
    private Float rate;

    public CurrencyConverterRequestWebDto() {
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }
}
