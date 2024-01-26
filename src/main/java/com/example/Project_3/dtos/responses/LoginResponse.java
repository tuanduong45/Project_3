package com.example.Project_3.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class LoginResponse {
    private String accessToken ;
    private String refreshToken;
    private Date issuedAt;







}
