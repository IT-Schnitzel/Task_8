package com.example.currencyconverter.controller;

import com.example.currencyconverter.model.CurrencyConversionRequest;
import com.example.currencyconverter.model.CurrencyConversionResponse;
import com.example.currencyconverter.model.CurrencyRateResponse;
import com.example.currencyconverter.service.CurrencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {

        this.currencyService = currencyService;
    }

    // GET /currencies/rates/{code}
    @GetMapping("/rates/{code}")
    public ResponseEntity<CurrencyRateResponse> getCurrencyRate(@PathVariable String code) {
        CurrencyRateResponse response = currencyService.getCurrencyRate(code);
        return ResponseEntity.ok(response);
    }

    // POST /currencies/convert
    @PostMapping("/convert")
    public ResponseEntity<CurrencyConversionResponse> convertCurrency(@RequestBody CurrencyConversionRequest request) {
        CurrencyConversionResponse response = currencyService.convertCurrency(request);
        return ResponseEntity.ok(response);
    }
}

