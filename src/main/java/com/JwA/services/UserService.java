package com.JwA.services;

import com.JwA.dtos.UserResponse;
import com.JwA.models.User;
import com.JwA.dtos.RegisterRequest;
import com.JwA.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponse registerUser(RegisterRequest registerRequest) {
        User newUser =  new User(registerRequest);
        return new UserResponse(userRepository.save(newUser));
    }

    @Transactional
    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }
}
