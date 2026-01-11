package org.example.services;

import org.example.dtos.requests.RegisterUserRequest;
import org.example.dtos.requests.UserSignInRequest;
import org.example.dtos.responses.RegisterUserResponse;
import org.example.dtos.responses.UserSignInResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest request);
    UserSignInResponse signInUser(UserSignInRequest request);

}
