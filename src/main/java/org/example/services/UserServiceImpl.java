package org.example.services;

import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.example.dtos.requests.RegisterUserRequest;
import org.example.dtos.requests.UserSignInRequest;
import org.example.dtos.responses.RegisterUserResponse;
import org.example.dtos.responses.UserSignInResponse;
import org.example.exceptions.InvalidCredentials;
import org.example.utils.UserMapper;

import static org.example.utils.UserMapper.mapRegisterUse;
import static org.example.utils.UserMapper.mapSignInUser;

public class UserServiceImpl implements UserService{

    private  UserRepository userRepository;


    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
    User user = UserMapper.map(request);
    User savedUser = userRepository.save(user);
    return mapRegisterUse(savedUser);

    }

    @Override
    public UserSignInResponse signInUser(UserSignInRequest request) {
      User user = userRepository.findByEmail(request.getEmail());

      if(user == null){
          throw new InvalidCredentials("Invalid Credentials");
      }

      if(!user.getPassword().equals(request.getPassword())){
          throw new InvalidCredentials("Invalid Credentials");

      }
     return mapSignInUser();
    }
}
