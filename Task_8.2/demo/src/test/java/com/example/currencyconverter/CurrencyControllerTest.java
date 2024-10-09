package com.example.currencyconverter;

import com.example.currencyconverter.controller.CurrencyController;
import com.example.currencyconverter.model.CurrencyConversionRequest;
import com.example.currencyconverter.model.CurrencyConversionResponse;
import com.example.currencyconverter.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(CurrencyController.class)
public class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService currencyService;

    @Test
    public void testConvertCurrency() throws Exception {
        CurrencyConversionResponse response = new CurrencyConversionResponse("USD", "RUB", 9000.5);
        Mockito.when(currencyService.convertCurrency(any(CurrencyConversionRequest.class))).thenReturn(response);

        mockMvc.perform(post("/currencies/convert")
                        .contentType("application/json")
                        .content("{\"fromCurrency\":\"USD\",\"toCurrency\":\"RUB\",\"amount\":100.5}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fromCurrency").value("USD"))
                .andExpect(jsonPath("$.toCurrency").value("RUB"))
                .andExpect(jsonPath("$.convertedAmount").value(9000.5));
    }
}
