package com.example.Project_3.enums.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum RoleEnum {


    HOSPITAL_MANAGER(1,"ROLE_HOSPITAL_MANAGER" , "HOSPITAL_MANAGER" ),
    DEPARTMENT_MANAGER(2 , "ROLE_DEPARTMENT_MANAGER" , "DEPARTMENT_MANAGER"),
    DEPARTMENT_PHARMACY_MANAGER(3 , "ROLE_DEPARTMENT_PHARMACY_MANAGER","DEPARTMENT_PHARMACY_MANAGER"),
    PHARMACY_STOCKER(4 , "ROLE_PHARMACY_STOCKER","PHARMACY_STOCKER") ,
    DEPARTMENT_NURSING(5,"ROLE_DEPARTMENT_NURSING" , "DEPARTMENT_NURSING") ;


    private final int id ;
    private final String roleCode ;
    private final String roleName ;




}
