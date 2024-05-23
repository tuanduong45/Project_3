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

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService ;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER') or hasAuthority('ROLE_HOSPITAL_MANAGER')")
    public void createUser(@RequestBody @Validated UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
    }
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER') " +
            "or hasAuthority('ROLE_HOSPITAL_MANAGER') or hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER')")
    public void updateUser(@RequestBody @Validated UserUpdateDTO updateDTO ,
                           @RequestParam(name = "id") Long userId ){
        userService.updateUser(updateDTO,userId);
    }
 /*   @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER') " +
            "or hasAuthority('ROLE_HOSPITAL_MANAGER') or hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER')")
    public void deleteUser(@RequestParam(name = "id") Long userId ){
        userService.deleteUser(userId);
    } */
    @GetMapping("/getList")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER') " +
            "or hasAuthority('ROLE_HOSPITAL_MANAGER') or hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER')")
    public List<IGetListUser> getListUsers (
            @RequestParam(name = "code" , required = false , defaultValue = "") String code ,
            @RequestParam(name = "name" , required = false , defaultValue = "") String name,
            @RequestParam(name = "phone" , required = false , defaultValue = "") String phoneNumber,
            @RequestParam(name = "email",required = false , defaultValue = "") String email ,
            @RequestParam(name = "departmentId" , required = false , defaultValue = "-1") Long departmentId ,
            @RequestParam(name = "roleId",required = false , defaultValue = "-1") Long roleId ){
        return userService.getListUser(code,name,phoneNumber,email,departmentId,roleId);
    }
    @PutMapping("/switchStatus")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER')" )
          //  "or hasAuthority('ROLE_HOSPITAL_MANAGER') or hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER')")
    public void switchUserStatus(@RequestParam(name = "id") Long userId , @RequestParam(name = "status")UserStatusEnum statusEnum) {
        userService.switchUserStatus(userId,statusEnum);
    }

}
