package com.v0_b0.currenciesandgifs.services;

import com.v0_b0.currenciesandgifs.clients.GiphyFeignClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GiphyService {

    @Value("${giphy.api.key}")
    private String apiKey;

    private final GiphyFeignClient client;

    public GiphyService(GiphyFeignClient client) {
        this.client = client;
    }

    public String getGifUrl(String tag){
        return client.getGifData(apiKey, tag).getData().get("image_url").toString();
    }
}
