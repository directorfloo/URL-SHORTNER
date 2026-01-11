package org.example.dtos.responses;


import lombok.Data;

@Data
public class RegisterUserResponse {

    private String message;
    private String userId;
    private String email;

}
