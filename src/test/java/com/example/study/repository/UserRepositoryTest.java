package com.example.study.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.study.model.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;



@SpringBootTest
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    

    @Test
    public void create(){
        // User u = user.builder().account("account")
        //             .email("email")
        //             .phoneNumber("010-0000-0000")
        //             .createdAt(LocalDateTime.now())
        //             .createdBy("createdByTest")
        //             .build();
        // userRepository.save(u);
        User user = new User();
        user.setAccount("account");
        user.setEmail("email");
        user.setPhoneNumber("000-1111-2222");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("createdAt");
        
        User newUser = userRepository.save(user);
        System.out.println(newUser);
    }

    @Test
    public void read(){
        List<User> getUser = userRepository.findAll();
        log.info("show user : {} ", getUser);
    }



}
