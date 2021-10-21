package com.example.study.component;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class LoginUserAduitorAware implements AuditorAware<String>{

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("AdminServer");
    }
    
}
