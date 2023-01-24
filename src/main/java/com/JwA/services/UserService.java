package com.JwA.services;

import com.JwA.dtos.RegisterRequest;
import com.JwA.dtos.UserResponse;
import com.JwA.exceptions.InvalidUserInputException;
import com.JwA.exceptions.ResourcePersistanceException;
import com.JwA.models.User;
import com.JwA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<User> findByEmail(String email){
        return userRepository.checkEmail(email);
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public boolean isEmailAvailable(String email){
        if(userRepository.checkEmail(email).isPresent())
            throw new InvalidUserInputException("Email: " + email + " is already registered please try again. Or Log in with email & password.");
        return true;
    }

    @Transactional
    public UserResponse registerUser(RegisterRequest registerRequest) throws InvalidUserInputException, ResourcePersistanceException {
        User newUser = new User(registerRequest);
        isEmailAvailable(newUser.getEmail());
        return new UserResponse(userRepository.save(newUser));
    }



}
