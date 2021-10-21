package com.v0_b0.currenciesandgifs.controllers;

import com.v0_b0.currenciesandgifs.services.GiphyService;
import com.v0_b0.currenciesandgifs.services.OpenExchangeRatesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/api")
public class MainController {

    private final GiphyService giphyService;
    private final OpenExchangeRatesService openERService;

    public MainController(GiphyService giphyService, OpenExchangeRatesService openERService) {
        this.giphyService = giphyService;
        this.openERService = openERService;
    }

    @GetMapping("/gif")
    public String gifForCurrencyCode(@RequestParam(value = "code", required = false) String code, Model model){
        model.addAttribute("currencies", openERService.getCurrencies());
        String tag = openERService.getTagForCurrency(code, new Date());
        model.addAttribute("tag", tag);
        model.addAttribute("url", giphyService.getGifUrl(tag));
        return "main";
    }
}
