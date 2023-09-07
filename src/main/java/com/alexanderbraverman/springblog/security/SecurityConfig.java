package com.alexanderbraverman.springblog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity https) throws Exception {

        // TODO: Add security configuration here.
        //  Method authorizeHttpRequests() is deprecated and marked for removal.
        https.authorizeHttpRequests().anyRequest().permitAll();
        return https.build();
    }
}
