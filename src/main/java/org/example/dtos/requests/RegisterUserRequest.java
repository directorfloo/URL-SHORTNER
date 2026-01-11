package org.example.dtos.requests;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String email;
    private String password;
    private String confirmPassword;

}
