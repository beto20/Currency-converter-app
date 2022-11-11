package com.alberto.currency.converter.app.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public class CurrencyResponseWebDto implements Serializable {

    private static final long serialVersionUID = 7821843697794351765L;

    @Schema(description = "Monto", example = "100.00")
    private Float amount;
    @Schema(description = "Monto con tipo de cambio", example = "25.9362")
    private Float currencyTypeAmount;
    @Schema(description = "Tipo de cambio origen", example = "PEN")
    private String currencyOrigin;
    @Schema(description = "Tipo de cambio destino", example = "USD")
    private String currencyDestiny;

    public CurrencyResponseWebDto() {
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getCurrencyTypeAmount() {
        return currencyTypeAmount;
    }

    public void setCurrencyTypeAmount(Float currencyTypeAmount) {
        this.currencyTypeAmount = currencyTypeAmount;
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
        return "CurrencyResponseWebDto{" +
                "amount=" + amount +
                ", currencyTypeAmount=" + currencyTypeAmount +
                ", currencyOrigin='" + currencyOrigin + '\'' +
                ", currencyDestiny='" + currencyDestiny + '\'' +
                '}';
    }
}
