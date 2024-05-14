package com.example.Project_3.sevice.role;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    // get role name from userID
    List<String> getRoleNameFromUserID(Long userID);
}
