package com.gorest.curd.controller;

import com.gorest.curd.model.UserFromGorest;
import com.gorest.curd.service.UserServiceGoRest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserGorestController {

    @Autowired
    private UserServiceGoRest userService;

    @GetMapping
    public Flux<UserFromGorest> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public Mono<UserFromGorest> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Mono<UserFromGorest> createUser(@RequestBody UserFromGorest user) {
        return userService.createUser(user);
    }

    @PutMapping("{id}")
    public Mono<UserFromGorest> updateUser(@PathVariable Integer id, @RequestBody UserFromGorest user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }
}
