package com.v0_b0.currenciesandgifs.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpenExchangeRatesServiceTest {

    @Autowired
    private OpenExchangeRatesService service;

    @Value("${giphy.tag.rich}")
    private String richTag;

    @Value("${giphy.tag.broke}")
    private String brokeTag;

    @Value("${giphy.tag.error}")
    private String errorTag;

    Calendar testingDate = new GregorianCalendar(2021, Calendar.OCTOBER, 20);

    @Test
    void getTagForCurrency() {
        String tag = service.getTagForCurrency("BRL", testingDate.getTime());
        assertEquals(richTag, tag);

        tag = service.getTagForCurrency("BTC", testingDate.getTime());
        assertEquals(brokeTag, tag);

        tag = service.getTagForCurrency("IncorrectTag", testingDate.getTime());
        assertEquals(errorTag, tag);
    }

    @Test
    void getCurrencies() {
        Set<String> currencies = service.getCurrencies();
        assertNotNull(currencies);

        assertTrue(currencies.contains("BYN"));
        assertTrue(currencies.contains("BTC"));
        assertTrue(currencies.contains("RUB"));
        assertTrue(currencies.contains("EUR"));
        assertTrue(currencies.contains("PHP"));

        assertFalse(currencies.contains("BadCode"));
    }
}