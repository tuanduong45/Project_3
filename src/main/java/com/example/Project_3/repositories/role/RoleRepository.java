package com.example.Project_3.repositories.role;

import com.example.Project_3.entities.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role , Long> {
    Role findByName(String roleName);
}
