package com.example.Project_3.sevice.auth.impl;

import com.example.Project_3.dtos.requests.LoginRequest;
import com.example.Project_3.dtos.requests.SignUpRequest;
import com.example.Project_3.dtos.responses.JwtAuthenticationResponse;
import com.example.Project_3.dtos.user.UserSignUp;
import com.example.Project_3.entities.auth.AuthInfo;
import com.example.Project_3.entities.role.Role;
import com.example.Project_3.entities.users.User;
import com.example.Project_3.repositories.auth.AuthRepository;
import com.example.Project_3.repositories.user.UserRepository;
import com.example.Project_3.security.jwt.JwtUtils;
import com.example.Project_3.sevice.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository ;

    private final UserRepository userRepository ;

    private final JwtUtils jwtUtils ;

    private final PasswordEncoder passwordEncoder ;

    private final AuthenticationManager authenticationManager ;

    @Override
    public AuthInfo saveAuthInfo(Long userId, String token) {
        AuthInfo authInfo = authRepository.findFirstByUserIdOrderByCreatedAtDesc(userId).orElse(null);
        boolean tokenIsValid = jwtUtils.isTokenExpired(token);
        if(Objects.isNull(authInfo) || !tokenIsValid){
            if(Objects.nonNull(authInfo)){
                authInfo.setStatus((tokenIsValid ? 1 : 0));
                authRepository.save(authInfo);
            }
            AuthInfo newAuthInfo = AuthInfo.builder().userId(userId).token(token).status(1).createdAt(LocalDateTime.now())
                    .lastLoginAt(LocalDateTime.now()).build();
            return authRepository.save(newAuthInfo);
        }
        authInfo.setLastLoginAt(LocalDateTime.now());
        return authRepository.save(authInfo);
    }

    @Override
    public UserSignUp signUp(SignUpRequest signUpRequest) {
        UserSignUp userCreateDTO = new UserSignUp();
        userCreateDTO.setUserName(signUpRequest.getUserName());
        userCreateDTO.setFirstName(signUpRequest.getFirstName());
        userCreateDTO.setLastName(signUpRequest.getLastName());
        userCreateDTO.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        User user = new User();
        BeanUtils.copyProperties(userCreateDTO,user);
        userRepository.save(user);
        return userCreateDTO;
    }

    @Override
    public JwtAuthenticationResponse login(LoginRequest loginRequest) {
       /* Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
                loginRequest.getPassword()); */
         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));
         SecurityContextHolder.getContext().setAuthentication(authentication);
         User user = (User) authentication.getPrincipal();
         if (user == null){
             throw new BadCredentialsException("Username/password is incorrect");
         }
        /* User user = userRepository.findByUserName(loginRequest.getUserName())
                 .orElseThrow(()->new UsernameNotFoundException("Username don't exist")); */

         String token = jwtUtils.generateJwt(user);
         String refreshToken = jwtUtils.generateRefreshToken(new HashMap<>() , user);
         Set<String> roles = user.getRoles().stream().map(Role::getCode).collect(Collectors.toSet());
         saveAuthInfo(user.getId(),token);
         return JwtAuthenticationResponse.builder().token(token).refreshToken(refreshToken)
                 .roles(roles).build();
    }
}
