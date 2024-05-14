package com.example.Project_3.repositories.role;

import com.example.Project_3.constant.sql.userRole.SQLUserRole;
import com.example.Project_3.entities.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role , Long> {
    Role findByName(String roleName);
    @Query(nativeQuery = true,value = SQLUserRole.GET_ROLE_NAME)
    List<String> getRoleNameFromUserID (@Param("userID") Long userID);
}
