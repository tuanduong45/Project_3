package com.example.Project_3.security.service;

import com.example.Project_3.entities.users.User;
import com.example.Project_3.repositories.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(username));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Load user by use name error");
        }
    }
}
