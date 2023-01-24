package com.JwA.DefectDumper.serviceTests;

import com.JwA.dtos.RegisterRequest;
import com.JwA.dtos.UserResponse;
import com.JwA.models.User;
import com.JwA.repositories.UserRepository;
import com.JwA.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private RegisterRequest registerRequest;
    private UserResponse userResponse;
    private User user1;
    private User user2;

    @AfterEach
    public void cleanup() {
        Mockito.reset(userRepository);
    }

    @Test
    public void getAllUsersPositive() {
        user1 = new User(new RegisterRequest("email1@email.com","Password1*", "fake1", "user1", "Tester"));
        user2 = new User(new RegisterRequest("email2@email.com","Password1*", "fake2", "user2", "Tester"));
        when(userRepository.findAll()).thenReturn(List.of(user1, user2));
        List<UserResponse> actualUserResponses = userService.getAllUsers();
        List<UserResponse> expectedUserResponses =  List.of(new UserResponse(user1), new UserResponse(user2));
        Assert.assertEquals(expectedUserResponses, actualUserResponses);
    }

    @Test
    public void getAllUsersNegative() {
        Assert.fail();
    }

    @Test
    public void passwordEncrypted() {
        Assert.fail();
    }

    @Test
    public void registerPositive() {
        Assert.fail();
    }

    @Test
    public void registerNegative() {
        Assert.fail();
    }

    @Test
    public void findByEmailPositive() {
        Assert.fail();
    }

    @Test
    public void findByEmailNegative() {
        Assert.fail();
    }

    @Test
    public void isEmailAvailablePositive() {
        Assert.fail();
    }

    @Test
    public void isEmailAvailableNegative() {
        Assert.fail();
    }


}
