package com.alberto.currency.converter.app.model.dto.request;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class CurrencyRequestWebDto implements Serializable {

    private static final long serialVersionUID = 7821843697794351765L;

    @Min(value = 0, message = "Debe ingresar un monto mayor a cero")
    private Float amount;
    @NotBlank(message = "Debe ingresar el tipo de cambio origen")
    private String currencyOrigin;
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
