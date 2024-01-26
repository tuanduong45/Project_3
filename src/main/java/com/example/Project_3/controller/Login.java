package com.example.Project_3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Login {
    @GetMapping("/currentUser")
    public ResponseEntity<?> getCurrentUser(){
        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication());
    }
}
