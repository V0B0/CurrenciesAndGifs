package com.v0_b0.currenciesandgifs.clients;

import com.v0_b0.currenciesandgifs.dto.OpenExRatesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "openExchangesRatesFeignClient",url = "${openER.api.url}")
public interface OpenExchangesRatesFeignClient {

    @GetMapping("/historical/{date}.json")
    OpenExRatesDTO getCurrencies(@PathVariable("date")String date,
                                 @RequestParam("app_id") String appId);

    @GetMapping("/currencies.json")
    Map<String, Object> getAllCurrencies();
}
