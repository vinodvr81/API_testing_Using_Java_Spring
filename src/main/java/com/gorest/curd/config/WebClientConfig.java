package com.gorest.curd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${gorest.api.url}")
    private String baseUrl;

    @Value("${gorest.api.password}")
    private String password;

    @Bean
    public WebClient webClient() {
    	return WebClient.builder()
    	        .baseUrl(baseUrl)
    	        .defaultHeader("Authorization", "Bearer " + password)
    	        .build();
    }
    
}