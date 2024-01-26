package com.example.Project_3.controller.userRole;

import com.example.Project_3.sevice.userRole.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService ;

    @GetMapping("/getList")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER') or hasAuthority('ROLE_HOSPITAL_MANAGER')")
    public Set<Long> getListUserId(@RequestParam Set<Long> lstRoleId){
        return userRoleService.getListUserId(lstRoleId);
    }
}
