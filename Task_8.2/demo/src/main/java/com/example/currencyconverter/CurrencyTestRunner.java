package com.example.currencyconverter;

import com.example.currencyconverter.client.CurrencyClient;
import com.example.currencyconverter.model.CurrencyRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CurrencyTestRunner implements CommandLineRunner {

    private final CurrencyClient currencyClient;

    @Autowired
    public CurrencyTestRunner(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    @Override
    public void run(String... args) {
        CurrencyRateResponse response = currencyClient.fetchCurrencyRate("AUD");
        System.out.println(response); // или используйте другой способ вывода
    }
}
