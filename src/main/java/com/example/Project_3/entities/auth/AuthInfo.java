package com.example.Project_3.entities.auth;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "auth_info")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false , unique = true)
    private Long id ;
    @Column(name = "user_id")
    private Long userId ;
    @Column(name = "token")
    private String token ;
    @Column(name = "status")
    private Integer status;
    @Column(name = "create_at" , nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "last_login_at",nullable = false )
    private LocalDateTime lastLoginAt;
}
