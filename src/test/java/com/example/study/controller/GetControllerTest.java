package com.example.study.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@SpringBootTest
@AutoConfigureMockMvc
public class GetControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    void testGetRequest() throws Exception{
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/getMethod")
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Hi getMethod"))
        .andDo(MockMvcResultHandlers.print());

    }
}
