package com.LAB.LabSystem.SecuirtyConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder
{
@Bean
    public String encode(String rawPassword)
        {
        return new BCryptPasswordEncoder().encode(rawPassword);
        }
}

