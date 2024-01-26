package com.example.Project_3.dtos.responses;

import com.example.Project_3.entities.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtAuthenticationResponse {
    private String token ;
    private String refreshToken;
    private Set<String> roles ;
}
