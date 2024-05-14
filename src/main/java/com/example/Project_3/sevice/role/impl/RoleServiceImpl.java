package com.example.Project_3.sevice.role.impl;

import com.example.Project_3.repositories.role.RoleRepository;
import com.example.Project_3.sevice.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository ;
    @Override
    public List<String> getRoleNameFromUserID(Long userID) {
        return roleRepository.getRoleNameFromUserID(userID);
    }
}
