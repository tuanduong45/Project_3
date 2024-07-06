package com.example.Project_3.controller.user;

import com.example.Project_3.dtos.user.IGetListUser;
import com.example.Project_3.dtos.user.UserCreateDTO;
import com.example.Project_3.dtos.user.UserUpdateDTO;
import com.example.Project_3.enums.user.UserStatusEnum;
import com.example.Project_3.sevice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService ;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_HOSPITAL_MANAGER')")
    public void createUser(@RequestBody @Validated UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
    }
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER') " +
            "or hasAuthority('ROLE_HOSPITAL_MANAGER') " +
            "or hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') " +
            "or hasAuthority('ROLE_ADMIN')")
    public void updateUser(@RequestBody @Validated UserUpdateDTO updateDTO ,
                           @RequestParam(name = "id") Long userId ){
        userService.updateUser(updateDTO,userId);
    }

    @GetMapping("/get-list")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER') " +
            "or hasAuthority('ROLE_HOSPITAL_MANAGER') " +
            "or hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') " +
            "or hasAuthority('ROLE_ADMIN')")
    public List<IGetListUser> getListUsers (
            @RequestParam(name = "code" , required = false , defaultValue = "") String code ,
            @RequestParam(name = "name" , required = false , defaultValue = "") String name,
            @RequestParam(name = "phone" , required = false , defaultValue = "") String phoneNumber,
            @RequestParam(name = "email",required = false , defaultValue = "") String email ,
            @RequestParam(name = "departmentId" , required = false , defaultValue = "-1") Long departmentId ,
            @RequestParam(name = "roleId",required = false , defaultValue = "-1") Long roleId ){
        return userService.getListUser(code,name,phoneNumber,email,departmentId,roleId);
    }
    @GetMapping("/switch-status")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER') " +
            "or hasAuthority('ROLE_HOSPITAL_MANAGER') " +
            "or hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') " +
            "or hasAuthority('ROLE_ADMIN')")
          //  "or hasAuthority('ROLE_HOSPITAL_MANAGER') or hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER')")
    public void switchUserStatus(@RequestParam(name = "id") Long userId) {
        userService.switchUserStatus(userId);
    }

    @GetMapping("/get-current-user-name")
    public String getCurrentUser() {
        return userService.getCurrentUser().getUserName();
    }

}
