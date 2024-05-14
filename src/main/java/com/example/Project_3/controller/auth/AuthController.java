package com.example.Project_3.controller.auth;

import com.example.Project_3.dtos.requests.LoginRequest;
import com.example.Project_3.dtos.requests.SignUpRequest;
import com.example.Project_3.dtos.responses.JwtAuthenticationResponse;
import com.example.Project_3.dtos.user.UserSignUp;
import com.example.Project_3.security.jwt.JwtUtils;
import com.example.Project_3.sevice.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager ;
    @Autowired
    private JwtUtils jwtUtils ;
    @Autowired
    private AuthService authService ;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }
    @PostMapping("/signup")
    public ResponseEntity<UserSignUp> signUp(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }
}
