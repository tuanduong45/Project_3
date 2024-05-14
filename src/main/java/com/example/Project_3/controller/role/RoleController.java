package com.example.Project_3.controller.role;

import com.example.Project_3.sevice.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/getRoleName")
    public List<String> getRoleNameFromUserID (@RequestParam("userID") Long userID){
        return roleService.getRoleNameFromUserID(userID);
    }
}
