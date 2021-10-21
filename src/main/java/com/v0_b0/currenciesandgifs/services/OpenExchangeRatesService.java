package com.v0_b0.currenciesandgifs.services;

import com.v0_b0.currenciesandgifs.clients.OpenExchangesRatesFeignClient;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Service
public class OpenExchangeRatesService {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private final OpenExchangesRatesFeignClient client;
    @Getter
    private final Set<String> currencies;

    @Value("${openER.app.id}")
    private String appId;
    @Value("${giphy.tag.rich}")
    private String richTag;
    @Value("${giphy.tag.broke}")
    private String brokeTag;
    @Value("${giphy.tag.error}")
    private String errorTag;

    public OpenExchangeRatesService(OpenExchangesRatesFeignClient client) {
        this.client = client;
        currencies = client.getAllCurrencies().keySet();
    }

    public String getTagForCurrency(String code, Date date) {
        if (!currencies.contains(code)) return errorTag;
        return getRate(code, date) > getRate(code, yesterday(date)) ? richTag : brokeTag;
    }

    private Float getRate(String code, Date date) {
        return client.getCurrencies(sdf.format(date), appId).getRates().get(code);
    }

    private Date yesterday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }
}
