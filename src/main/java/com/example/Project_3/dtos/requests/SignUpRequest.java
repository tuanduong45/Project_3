package com.example.Project_3.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String identificationNumber;
    private int identityType;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

}
