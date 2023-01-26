package com.JwA.controllers;

import com.JwA.dtos.RegisterRequest;
import com.JwA.dtos.UserResponse;
import com.JwA.models.User;
import com.JwA.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse register(@RequestBody RegisterRequest registerRequest) {
        System.out.println(registerRequest);
        return userService.registerUser(registerRequest);
    }
}
