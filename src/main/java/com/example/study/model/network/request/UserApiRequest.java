package com.example.study.model.network.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.study.model.enumclass.UserStatus;
import com.fasterxml.jackson.core.JsonParser.NumberType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserApiRequest {
 
    private Long id;

    private String account;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String email;

    private String phoneNumber;
    
}
