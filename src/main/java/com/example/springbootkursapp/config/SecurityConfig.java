package com.example.springbootkursapp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //podstawa pod security filter chain
public class SecurityConfig
{
    @Bean //adnotacja, która oznacza „stwórz ten obiekt i zarządzaj nim w Springu jako singletonem”
    public PasswordEncoder passwordEncoder()
        {
            return new BCryptPasswordEncoder();
        }
    @Bean //aby automatycznie wleciało do security frameworka
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                        .requestMatchers("/users/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
        ).formLogin(formLogin -> formLogin.loginPage("/login").permitAll()); //formlogin daje domyslna strone logowania, permitAll pozwala wszytskim to widziec

        return http.build();
    }
}
