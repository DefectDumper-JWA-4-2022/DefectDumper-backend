package com.JwA.services;

import com.JwA.models.User;
import com.google.common.hash.Hashing;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class AuthService {
    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    public Optional<User> findByCredentials(String email, String password) {
        String hashPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        System.out.println("");
        System.out.println("The hashPassword is " + hashPassword);
        return userService.findByCredentials(email,hashPassword);
    }

}
