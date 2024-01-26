package com.example.Project_3.controller.department;

import com.example.Project_3.dtos.department.DepartmentCreateDTO;
import com.example.Project_3.dtos.department.DepartmentUpdateDTO;
import com.example.Project_3.dtos.department.GetListDepartment;
import com.example.Project_3.dtos.department.IGetListDepartment;
import com.example.Project_3.entities.department.Department;
import com.example.Project_3.enums.role.RoleEnum;
import com.example.Project_3.security.annotationAuthCustom.hospitalManager.isHospitalManager;
import com.example.Project_3.sevice.department.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService ;
    @GetMapping("/getList")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER') or hasAuthority('ROLE_HOSPITAL_MANAGER')")
    public List<IGetListDepartment> getListDepartment(
            @RequestParam(name = "id",required = false , defaultValue = "-1") Long id ,
            @RequestParam(name = "code" , required = false , defaultValue = "") String code,
            @RequestParam(name = "email" , required = false , defaultValue = "") String email,
            @RequestParam(name = "name" , required = false , defaultValue = "") String name ,
            @RequestParam(name = "phone" , required = false , defaultValue = "") String phoneNumber){
        return departmentService.getListDepartment(id ,code,email,name,phoneNumber);
    }


    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_HOSPITAL_MANAGER')")
    public void createDepartment(@RequestBody @Validated DepartmentCreateDTO departmentCreateDTO){
        departmentService.createDepartment(departmentCreateDTO);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER') or hasAuthority('ROLE_HOSPITAL_MANAGER')")
    public void updateDepartment(@RequestParam("id") Long id , @RequestBody @Validated DepartmentUpdateDTO updateDTO){
        departmentService.updateDepartment(id,updateDTO);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ROLE_HOSPITAL_MANAGER')")
    public void deleteDepartment(@RequestParam("id") Long id){
        departmentService.deleteDepartment(id);
    }

}
