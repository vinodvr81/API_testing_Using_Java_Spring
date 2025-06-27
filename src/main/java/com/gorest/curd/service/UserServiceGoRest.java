package com.gorest.curd.service;

import com.gorest.curd.model.UserFromGorest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceGoRest {
	
    @Autowired
    private WebClient webClient;


    public Flux<UserFromGorest> getAllUsers() {
        return webClient.get()
                .retrieve()
                .bodyToFlux(UserFromGorest.class);
    }

    public Mono<UserFromGorest> getUserById(Integer id) {
        return webClient.get()
                .uri("{id}", id)
                .retrieve()
                .bodyToMono(UserFromGorest.class);
    }

    public Mono<UserFromGorest> createUser(UserFromGorest user) {
        return webClient.post()
                .bodyValue(user)
                .retrieve()
                .bodyToMono(UserFromGorest.class);
    }

    public Mono<UserFromGorest> updateUser(Integer id, UserFromGorest user) {
        return webClient.put()
                .uri("{id}", id)
                .bodyValue(user)
                .retrieve()
                .bodyToMono(UserFromGorest.class);
    }

    public Mono<Void> deleteUser(Integer id) {
        return webClient.delete()
                .uri("{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
	

