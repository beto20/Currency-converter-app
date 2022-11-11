package com.alberto.currency.converter.app.model.dto.response;

import java.io.Serializable;

public class CurrencyResponseApiDto implements Serializable {

    private static final long serialVersionUID = 7821843697794351765L;

    private String date;
    private Info info;
    private Query query;
    private Float result;
    private String success;


    public static class Info implements Serializable {

        private static final long serialVersionUID = 7821843697794351765L;
        private Float rate;

        public Float getRate() {
            return rate;
        }

        public void setRate(Float rate) {
            this.rate = rate;
        }
    }

    public static class Query implements Serializable {

        private static final long serialVersionUID = 7821843697794351765L;
        private Float amount;
        private String from;
        private String to;

        public Float getAmount() {
            return amount;
        }

        public void setAmount(Float amount) {
            this.amount = amount;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }
    }

    public CurrencyResponseApiDto() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Float getResult() {
        return result;
    }

    public void setResult(Float result) {
        this.result = result;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

}
