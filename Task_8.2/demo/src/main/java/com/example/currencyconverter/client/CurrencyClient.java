package com.example.currencyconverter.client;

import com.example.currencyconverter.model.CurrencyRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class CurrencyClient {

    private final RestTemplate restTemplate;
    private final String currencyApiUrl;

    @Autowired
    public CurrencyClient(RestTemplate restTemplate, @Value("${currency.api.url}") String currencyApiUrl) {
        this.restTemplate = restTemplate;
        this.currencyApiUrl = currencyApiUrl;
    }

    public CurrencyRateResponse fetchCurrencyRate(String code) {
        String url = UriComponentsBuilder.fromHttpUrl(currencyApiUrl)
                .path("/scripts/XML_daily.asp")
                .queryParam("code", code)
                .toUriString();
        System.out.println(url);
        return restTemplate.getForObject(url, CurrencyRateResponse.class);
    }

}



