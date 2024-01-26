package com.example.Project_3.sevice.department;

import com.example.Project_3.dtos.department.DepartmentCreateDTO;
import com.example.Project_3.dtos.department.DepartmentUpdateDTO;
import com.example.Project_3.dtos.department.GetListDepartment;
import com.example.Project_3.dtos.department.IGetListDepartment;
import com.example.Project_3.entities.department.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    List<IGetListDepartment> getListDepartment(Long id ,String code , String email, String name , String numberPhone);
    void createDepartment(DepartmentCreateDTO departmentCreateDTO);
    void updateDepartment(Long id , DepartmentUpdateDTO updateDTO);
    void deleteDepartment(Long id );



}
