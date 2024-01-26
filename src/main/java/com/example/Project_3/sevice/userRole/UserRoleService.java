package com.example.Project_3.sevice.userRole;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserRoleService {
     Set<Long> getListUserId(Set<Long> lstRoleId);

}
