package com.example.Project_3.sevice.department.impl;

import com.example.Project_3.constant.message.errorKey.ErrorKey;
import com.example.Project_3.constant.message.messageConst.MessageConst;
import com.example.Project_3.dtos.department.DepartmentCreateDTO;
import com.example.Project_3.dtos.department.DepartmentUpdateDTO;
import com.example.Project_3.dtos.department.GetListDepartment;
import com.example.Project_3.dtos.department.IGetListDepartment;
import com.example.Project_3.entities.department.Department;
import com.example.Project_3.exceptions.BadRequestException;
import com.example.Project_3.exceptions.exceptionFactory.ExceptionFactory;
import com.example.Project_3.repositories.department.DepartmentRepository;
import com.example.Project_3.sevice.department.DepartmentService;
import com.example.Project_3.utils.auth.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService  {
    private final ExceptionFactory exceptionFactory;
    private final DepartmentRepository departmentRepository ;


    @Override
    public List<IGetListDepartment> getListDepartment(Long id ,String code, String email, String name, String numberPhone) {
          return departmentRepository.getListDepartment(id,code,email,name,numberPhone);
    }

    @Override
    public void createDepartment(DepartmentCreateDTO departmentCreateDTO) {
//        if (AuthUtils.isHospitalManager()) {
            if (departmentRepository.existsByCode(departmentCreateDTO.getCode())) {
                throw exceptionFactory.resourceNotFoundException(ErrorKey.Department.EXISTED_ERROR_CODE,
                        MessageConst.Resources.DEPARTMENT, MessageConst.RESOURCE_EXISTED
                        , ErrorKey.Department.CODE, departmentCreateDTO.getCode());
            }
            Department department = new Department();
            BeanUtils.copyProperties(departmentCreateDTO, department);
             departmentRepository.save(department);
//        } else {
//            throw exceptionFactory.permissionDeniedException(ErrorKey.Department.PERMISSION_DENIED_ERROR_CODE,
//                    MessageConst.Resources.DEPARTMENT, MessageConst.PERMISSIONS_DENIED);
//        }
    }

    @Override
    public void updateDepartment(Long id, DepartmentUpdateDTO updateDTO) {
          Department department = departmentRepository.findById(id).orElseThrow(() ->
                  exceptionFactory.resourceNotFoundException(ErrorKey.Department.NOT_FOUND_ERROR_CODE
                          ,MessageConst.RESOURCE_NOT_FOUND , MessageConst.Resources.DEPARTMENT
                          ,ErrorKey.Department.ID,String.valueOf(id)));
          BeanUtils.copyProperties(updateDTO,department);
          departmentRepository.save(department);



    }

    @Override
    public void deleteDepartment(Long id) {
        if(departmentRepository.existsById(id)){
            departmentRepository.deleteById(id);
        }else {
            throw exceptionFactory.resourceNotFoundException(ErrorKey.Department.NOT_FOUND_ERROR_CODE,MessageConst.Resources.DEPARTMENT,
                    MessageConst.RESOURCE_NOT_FOUND,ErrorKey.Department.ID , String.valueOf(id));
        }
    }
}
