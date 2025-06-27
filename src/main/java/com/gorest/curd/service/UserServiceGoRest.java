package com.gorest.curd.service;

import com.gorest.curd.model.UserFromGorest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceGoRest {

	@Autowired
	private WebClient webClient;

	public Flux<UserFromGorest> getAllUsers() {
		return webClient.get().retrieve().bodyToFlux(UserFromGorest.class);
	}

	public Mono<UserFromGorest> getUserById(int id) {
		return webClient.get().uri("/{id}", id).retrieve().bodyToMono(UserFromGorest.class);
	}

	public Mono<UserFromGorest> createUser(UserFromGorest user) {
		return webClient.post().bodyValue(user).retrieve().bodyToMono(UserFromGorest.class);
	}

	public Mono<UserFromGorest> updateUser(int id, UserFromGorest user) {
		return webClient.put().uri("/{id}", id).bodyValue(user).retrieve().bodyToMono(UserFromGorest.class);
	}

	public Mono<Void> deleteUser(int id) {
		return webClient.delete().uri("/{id}", id).retrieve().bodyToMono(Void.class);
	}
}
