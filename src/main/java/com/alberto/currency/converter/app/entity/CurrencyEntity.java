package com.alberto.currency.converter.app.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String typeOrigin;
    private String typeDestiny;
    private Float rateDestiny;

    public CurrencyEntity() {
    }

    public void setTypeOrigin(String typeOrigin) {
        this.typeOrigin = typeOrigin;
    }

    public String getTypeDestiny() {
        return typeDestiny;
    }

    public void setTypeDestiny(String typeDestiny) {
        this.typeDestiny = typeDestiny;
    }

    public Float getRateDestiny() {
        return rateDestiny;
    }

    public void setRateDestiny(Float rateDestiny) {
        this.rateDestiny = rateDestiny;
    }
}


