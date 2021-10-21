package com.v0_b0.currenciesandgifs.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void home() throws Exception {
        mockMvc.perform(get("/api/gif"))
                .andExpect(status().isOk());
    }

    @Test
    void getPageWithGif() throws Exception {
        mockMvc.perform(get("/api/gif/")
                .param("code", "BYN"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }

    @Test
    void getPageWithBadCode() throws Exception {
        mockMvc.perform(get("/api/gif/")
                .param("code", "BadCode"))
                .andExpect(status().isOk());
    }
}