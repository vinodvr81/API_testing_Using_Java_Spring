package com.gorest.curd.controller;

import com.gorest.curd.model.UserFromGorest;
import com.gorest.curd.service.UserServiceGoRest;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class UserGorestController {

    @Autowired
    private UserServiceGoRest userService;

    @GetMapping
    public Flux<UserFromGorest> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<UserFromGorest> getUserById(@PathVariable(name = "id")  int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Mono<UserFromGorest> createUser(@RequestBody UserFromGorest user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public Mono<UserFromGorest> updateUser(@PathVariable(name = "id") int id, @RequestBody UserFromGorest user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable(name = "id") int id) {
        return userService.deleteUser(id);
    }
}
