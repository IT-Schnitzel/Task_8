package com.example.currencyconverter.model;

public class CurrencyConversionResponse {
    private String fromCurrency;
    private String toCurrency;
    private double convertedAmount;

    public CurrencyConversionResponse(String fromCurrency, String toCurrency, double convertedAmount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.convertedAmount = convertedAmount;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}
