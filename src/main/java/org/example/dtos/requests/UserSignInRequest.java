package org.example.dtos.requests;


import lombok.Data;

@Data
public class UserSignInRequest {
    private String email;
    private String password;
}
