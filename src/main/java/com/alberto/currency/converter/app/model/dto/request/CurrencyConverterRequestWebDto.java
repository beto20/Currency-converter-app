package com.alberto.currency.converter.app.model.dto.request;

import java.io.Serializable;

public class CurrencyConverterRequestWebDto implements Serializable {

    private static final long serialVersionUID = 7821843697794351765L;

    private String currencyType;
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
