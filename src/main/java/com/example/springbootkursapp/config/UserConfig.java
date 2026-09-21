package com.example.springbootkursapp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {
    public PasswordEncoder passwordEncoder()
    @Bean //adnotacja, która oznacza „stwórz ten obiekt i zarządzaj nim w Springu jako singletonem”
    {
        return new BCryptPasswordEncoder();
    }
}
