package org.example.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private String userId;
    private String  email;
    private String password;
    private String confirmPassword;

}
