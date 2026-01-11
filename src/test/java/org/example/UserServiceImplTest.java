package org.example;

import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.example.dtos.requests.RegisterUserRequest;
import org.example.dtos.requests.UserSignInRequest;
import org.example.dtos.responses.RegisterUserResponse;
import org.example.dtos.responses.UserSignInResponse;
import org.example.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Main.class)
public class UserServiceImplTest {



        @Autowired
        private UserService userService;

        @Autowired
        private UserRepository userRepository;

        @BeforeEach
        void cleanDb() {
            userRepository.deleteAll();
        }

        @Test
        void registerUserTest() {
            RegisterUserRequest request = new RegisterUserRequest();
            request.setEmail("tayo@gmail.com");
            request.setPassword("password");
            request.setConfirmPassword("password");

            RegisterUserResponse response = userService.registerUser(request);

            assertEquals("Successfully Signed Up", response.getMessage());
        }
        @Test
        void  signInUserTest() {
            User user = new User();
            user.setEmail("olamide@gmail.com");
            user.setPassword("olasexy123@");

            userRepository.save(user);



            UserSignInRequest signInRequest = new UserSignInRequest();
            signInRequest.setEmail("olamide@gmail.com");
            signInRequest.setPassword("olasexy123@");

            UserSignInResponse response = userService.signInUser(signInRequest);
            assertEquals("Successfully Signed In", response.getMessage());
        }


    }


