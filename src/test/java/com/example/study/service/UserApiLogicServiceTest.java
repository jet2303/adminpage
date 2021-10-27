package com.example.study.service;

import java.time.LocalDateTime;

import com.example.study.controller.api.UserApiController;
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
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class UserApiLogicServiceTest {
    
    @Autowired
    private UserApiController userApiController;
    @Autowired
    private MockMvc mockMvc;




    @Test
    @Transactional
    void testCreate() throws Exception{
        
        // String content = "{\"transaction_time\":\"2021-10-20T17:25:04.7341107\",\"result_code\":\"ERROR\",\"description\":\"OK\",\"data\":{\"id\":3,\"account\":\"CreateTest02\",\"password\":\"CreateTest02\",\"status\":\"UNREGISTERED\",\"email\":\"CreateTest01@GMAIL.COM\",\"phone_number\":\"010-1234-1234\",\"registered_at\":\"2021-10-20T16:51:01\",\"unregistered_at\":null}}";
        String content = "{\"transaction_time\":\""+LocalDateTime.now() +"\",\"result_code\":\"ERROR\",\"description\":\"OK\",\"data\":{\"id\":3,\"account\":\"CreateTest02\",\"password\":\"CreateTest02\",\"status\":\"UNREGISTERED\",\"email\":\"CreateTest01@GMAIL.COM\",\"phone_number\":\"010-1234-1234\",\"registered_at\":\"2021-10-20T16:51:01\",\"unregistered_at\":null}}";
        // String content = "{\"transaction_time\":\""+LocalDateTime.now() +"\",\"result_code\":\"ERROR\",\"description\":\"OK\",\"data\":{\"id\":3,\"account\":\"CreateTest02\",\"password\":\"CreateTest02\",\"status\":\"UNREGISTERED\"email\":\"CreateTest01@GMAIL.COM\",\"phone_number\":\"010-1234-1234\",\"registered_at\":\"2021-10-20T16:51:01\",\"unregistered_at\":null}}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
                                                .content(content)
                                                .contentType(MediaType.APPLICATION_JSON)
                        )       
        
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
                

    }

    @Test
    void testRead() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/4"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
                                                
    }

    @Test
    @Transactional
    void testUpdate() throws Exception{
        String content = "{\"transaction_time\":\"2021-10-20T17:25:04.7341107\",\"result_code\":\"OK\",\"description\":\"OK\",\"data\":{\"id\":3,\"account\":\"CreateTest03\",\"password\":\"CreateTest03\",\"status\":\"UNREGISTERED\",\"email\":\"CreateTest01@GMAIL.COM\",\"phone_number\":\"010-1234-1234\",\"registered_at\":\"2021-10-20T16:51:01\",\"unregistered_at\":null}}";
        mockMvc.perform(MockMvcRequestBuilders.put("/api/user")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    void testDelete() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/user/3"))
                                    .andExpect(MockMvcResultMatchers.status().isOk())
                                    .andDo(MockMvcResultHandlers.print())
                                    .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    void pageTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/user")
                                                                    .param("page", "0")
        
                                )
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andDo(MockMvcResultHandlers.print())
                                .andReturn();
          
        // mvcResult.getResponse().getContentAsString().
    }


    

    
}
