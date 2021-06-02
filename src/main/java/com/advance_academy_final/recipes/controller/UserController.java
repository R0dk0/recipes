package com.advance_academy_final.recipes.controller;


import com.advance_academy_final.recipes.dto.UserDto;
import com.advance_academy_final.recipes.model.User;
import com.advance_academy_final.recipes.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public Set<UserDto> findAll() {
        return userService.returnAllUsers();

    }

    @GetMapping(value = "/{name}")
    public User findUser(@PathVariable(value = "name") String username) {
        User foundUser = userService.findByUsername(username);

        return foundUser;
    }

    @PostMapping
    public void save(@RequestBody User user) {
        userService.save(user);

    }
}