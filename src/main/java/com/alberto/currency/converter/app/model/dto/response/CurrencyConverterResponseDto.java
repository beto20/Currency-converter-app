package com.alberto.currency.converter.app.model.dto.response;

import java.io.Serializable;

public class CurrencyConverterResponseDto implements Serializable {

    private static final long serialVersionUID = 7821843697794351765L;

    private String message;

    public CurrencyConverterResponseDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
