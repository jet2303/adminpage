package com.example.study.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import lombok.extern.slf4j.Slf4j;


@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void testPostRequest() throws Exception{
        // SearchParam searchParam = new SearchParam("Account","email",1);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("account", "account");
        jsonObject.put("email", "email");
        jsonObject.put("page", 1);
        MvcResult result =  mockMvc.perform(
            MockMvcRequestBuilders.post("/api/postMethod")
                                    .content(jsonObject.toString())
                                    .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();

        log.info("{}", result.getResponse().getContentAsString());
        

    }
}
