package org.example.utils;

import org.example.data.models.User;
import org.example.dtos.requests.RegisterUserRequest;
import org.example.dtos.responses.RegisterUserResponse;
import org.example.dtos.responses.UserSignInResponse;

public class UserMapper {
    public static User map(RegisterUserRequest request) {
      User user = new User();
      user.setEmail(request.getEmail());
      user.setPassword(request.getPassword());
      user.setConfirmPassword(request.getConfirmPassword());
      return user;

}
public static RegisterUserResponse mapRegisterUse(User savedUser) {
    RegisterUserResponse response = new RegisterUserResponse();
    response.setMessage("Successfully Signed Up");
    response.setUserId(savedUser.getUserId());
    response.setEmail(savedUser.getEmail());
    return response;


    }
public  static UserSignInResponse mapSignInUser() {
    UserSignInResponse response = new UserSignInResponse();
    response.setMessage("Successfully Signed In");
    return response;
}
}
