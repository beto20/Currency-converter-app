package com.alberto.currency.converter.app.model.dto;

import java.io.Serializable;


public class CurrencyDto implements Serializable {

    private static final long serialVersionUID = 7821843697794351765L;


    private Float amount;
    private String currencyOrigin;
    private String currencyDestiny;

    public CurrencyDto() {
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
}
