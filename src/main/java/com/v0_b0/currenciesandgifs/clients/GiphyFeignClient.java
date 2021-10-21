package com.v0_b0.currenciesandgifs.clients;

import com.v0_b0.currenciesandgifs.dto.GiphyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphyFeignClient",url = "${giphy.api.url}")
public interface GiphyFeignClient {

    @GetMapping("/random")
    GiphyDTO getGifData(@RequestParam("api_key") String apiKey,
                        @RequestParam("tag") String tag);
}
