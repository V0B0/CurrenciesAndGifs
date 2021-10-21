package com.v0_b0.currenciesandgifs.dto;

import lombok.Data;

import java.util.Map;

@Data
public class OpenExRatesDTO {
    private String disclaimer;
    private String license;
    private String timestamp;
    private String base;
    private Map<String, Float> rates;
}
