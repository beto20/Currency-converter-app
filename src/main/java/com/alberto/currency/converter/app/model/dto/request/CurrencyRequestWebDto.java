package com.alberto.currency.converter.app.model.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CurrencyRequestWebDto implements Serializable {

    private static final long serialVersionUID = 7821843697794351765L;

    @Schema(description = "Monto de cambio", example = "100.00")
    @DecimalMin(value = "0.1", message = "Debe ingresar un monto mayor a cero")
    private Float amount;
    @Schema(description = "Tipo de cambio origen", example = "PEN")
    @Size(min = 2, max = 5)
    @NotBlank(message = "Debe ingresar el tipo de cambio origen")
    private String currencyOrigin;
    @Schema(description = "Tipo de cambio destino", example = "USD")
    @Size(min = 2, max = 5)
    @NotBlank(message = "Debe ingresar el tipo de cambio destino")
    private String currencyDestiny;


    public CurrencyRequestWebDto() {
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getCurrencyOrigin() {
        return currencyOrigin;
    }

    public void setCurrencyOrigin(String currencyOrigin) {
        this.currencyOrigin = currencyOrigin;
    }

    public String getCurrencyDestiny() {
        return currencyDestiny;
    }

    public void setCurrencyDestiny(String currencyDestiny) {
        this.currencyDestiny = currencyDestiny;
    }

    @Override
    public String toString() {
        return "CurrencyRequestApiDto{" +
                "amount=" + amount +
                ", currencyOrigin='" + currencyOrigin + '\'' +
                ", currencyDestiny='" + currencyDestiny + '\'' +
                '}';
    }
}
