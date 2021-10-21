package com.v0_b0.currenciesandgifs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrenciesAndGifsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrenciesAndGifsApplication.class, args);
    }

}
