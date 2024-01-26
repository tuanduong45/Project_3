package com.example.Project_3.sevice.auth;

import com.example.Project_3.dtos.requests.LoginRequest;
import com.example.Project_3.dtos.requests.SignUpRequest;
import com.example.Project_3.dtos.responses.JwtAuthenticationResponse;
import com.example.Project_3.dtos.user.UserSignUp;
import com.example.Project_3.entities.auth.AuthInfo;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    AuthInfo saveAuthInfo(Long userId , String token );

    UserSignUp signUp(SignUpRequest signUpRequest);

    JwtAuthenticationResponse login(LoginRequest loginRequest);


}
