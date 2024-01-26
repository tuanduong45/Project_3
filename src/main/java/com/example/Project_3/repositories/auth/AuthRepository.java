package com.example.Project_3.repositories.auth;

import com.example.Project_3.entities.auth.AuthInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<AuthInfo, Long> {
    Optional<AuthInfo> findFirstByUserIdOrderByCreatedAtDesc(Long userId);


}
