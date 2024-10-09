package com.example.currencyconverter;

import com.example.currencyconverter.client.CurrencyClient;
import com.example.currencyconverter.model.CurrencyRateResponse;
import com.example.currencyconverter.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CurrencyTestRunnerTest {

    @Mock
    private CurrencyClient currencyClient;

    @InjectMocks
    private CurrencyService currencyService;

    @Test
    public void testFetchCurrencyRate() {
        CurrencyRateResponse expectedResponse = new CurrencyRateResponse("AUD", 0.67);
        when(currencyClient.fetchCurrencyRate("AUD")).thenReturn(expectedResponse);

        // Call the service method instead of directly calling the client
        CurrencyRateResponse actualResponse = currencyService.fetchCurrencyRate("AUD");
        assertEquals(expectedResponse.getCurrency(), actualResponse.getCurrency());
        assertEquals(expectedResponse.getRate(), actualResponse.getRate());
    }
}
