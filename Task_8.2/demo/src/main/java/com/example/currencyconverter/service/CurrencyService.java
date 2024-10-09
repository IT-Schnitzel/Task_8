package com.example.currencyconverter.service;

import com.example.currencyconverter.client.CurrencyClient;
import com.example.currencyconverter.exception.BadRequestException;
import com.example.currencyconverter.exception.NotFoundException;
import com.example.currencyconverter.model.CurrencyConversionRequest;
import com.example.currencyconverter.model.CurrencyConversionResponse;
import com.example.currencyconverter.model.CurrencyRateResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    private final CurrencyClient currencyClient;

    public CurrencyService(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }
    @Cacheable(value = "currencyRates", key = "#code")
    public CurrencyRateResponse getCurrencyRate(String code) {
        CurrencyRateResponse rateResponse = currencyClient.fetchCurrencyRate(code);
        if (rateResponse == null) {
            throw new NotFoundException("Currency code not found in Central Bank rates: " + code);
        }
        return rateResponse;
    }

    public CurrencyConversionResponse convertCurrency(CurrencyConversionRequest request) {
        if (request.getAmount() <= 0) {
            throw new BadRequestException("Amount must be greater than 0");
        }

        CurrencyRateResponse fromRate = getCurrencyRate(request.getFromCurrency());
        CurrencyRateResponse toRate = getCurrencyRate(request.getToCurrency());

        double convertedAmount = (request.getAmount() / fromRate.getRate()) * toRate.getRate();
        return new CurrencyConversionResponse(request.getFromCurrency(), request.getToCurrency(), convertedAmount);
    }

    public CurrencyRateResponse fetchCurrencyRate(String currencyCode) {
        return currencyClient.fetchCurrencyRate(currencyCode);
    }

}
