package org.example.controllers;

import org.example.dtos.responses.ApiResponse;
import org.example.dtos.requests.RegisterUserRequest;
import org.example.exceptions.UserManagementException;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {




        @Autowired
        private UserService userService;

        @PostMapping("/registerUser")
        public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest userRegisterRequest){
            try {
                return new ResponseEntity<>(new ApiResponse(true, userService.registerUser(userRegisterRequest)), HttpStatus.CREATED);
            } catch (UserManagementException e){
                return new  ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
            }
        }

}
