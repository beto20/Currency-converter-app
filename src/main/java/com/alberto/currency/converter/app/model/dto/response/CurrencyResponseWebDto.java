package com.alberto.currency.converter.app.model.dto.response;

import java.io.Serializable;

public class CurrencyResponseWebDto implements Serializable {

    private static final long serialVersionUID = 7821843697794351765L;

    private Float amount;
    private Float currencyTypeAmount;
    private String currencyOrigin;
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
