package com.v0_b0.currenciesandgifs.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GiphyServiceTest {

    @Autowired
    private GiphyService service;

    @Value("${giphy.tag.rich}")
    private String richTag;

    @Value("${giphy.tag.broke}")
    private String brokeTag;

    @Value("${giphy.tag.error}")
    private String errorTag;

    private final Pattern pattern = Pattern.compile("https://media.[.]giphy[.]com/media/\\w+/giphy[.]gif");

    @Test
    void getGifUrlForRochTag() {
        String url = service.getGifUrl(richTag);
        assertTrue(pattern.matcher(url).find(),"incorrect url = '"+url+'\'');
    }

    @Test
    void getGifUrlForBrokeTag() {
        String url = service.getGifUrl(brokeTag);
        assertTrue(pattern.matcher(url).find(),"incorrect url = '"+url+'\'');
    }

    @Test
    void getGifUrlForErrorTag() {
        String url = service.getGifUrl(errorTag);
        assertTrue(pattern.matcher(url).find(),"incorrect url = '"+url+'\'');
    }
}