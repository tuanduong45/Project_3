package com.example.Project_3.sevice.userRole.impl;

import com.example.Project_3.repositories.userRole.UserRoleRepository;
import com.example.Project_3.sevice.userRole.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository ;

    @Override
    public Set<Long> getListUserId(Set<Long> lstRoleId) {
        return userRoleRepository.getUserIdByRoleId(lstRoleId);
    }



}
