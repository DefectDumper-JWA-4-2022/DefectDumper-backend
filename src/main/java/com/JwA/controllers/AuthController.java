package com.JwA.controllers;

import com.JwA.dtos.LoginRequest;
import com.JwA.dtos.UserResponse;
import com.JwA.exceptions.UnauthorizedException;
import com.JwA.models.User;
import com.JwA.services.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(
            @RequestBody LoginRequest loginRequest,
            HttpServletResponse resp) {
        User authUser = authService.findByCredentials(
                loginRequest.getEmail(),
                loginRequest.getPassword())
                .orElseThrow(UnauthorizedException::new);
        //if (!authUser.isActive()) throw new UnauthorizedException("It's not there");
        return ResponseEntity.ok(new UserResponse(authUser));
    }
}
