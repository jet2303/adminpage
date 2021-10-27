package com.example.study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@AutoConfigureMockMvc
@SpringBootTest
public class PostControllerTest1 {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    
    
    @Autowired
    private GetController getController;
    
    // @Test
    // void testPostRequest() throws Exception{
    //     // SearchParam searchParam = new SearchParam("Account","email",1);

    //     String content = objectMapper.writeValueAsString(new SearchParam("Account","email",1));

    //     MvcResult result =  mockMvc.perform(
    //         MockMvcRequestBuilders.post("/api/post")
    //                                 .content(content)
    //                                 .contentType(MediaType.APPLICATION_JSON)
    //                                 // .content(searchParam)
    //     )
    //     .andExpect(MockMvcResultMatchers.status().isNotFound())
    //     .andDo(MockMvcResultHandlers.print())
    //     .andReturn();

    //     // System.out.println(result.getResponse().getContentAsString());
    //     assertEquals(result.getResponse().getContentAsString(),  content);

    // }
    @Test
    void headerTest() throws Exception{
        
        mockMvc.perform(MockMvcRequestBuilders.get("/api/header"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
