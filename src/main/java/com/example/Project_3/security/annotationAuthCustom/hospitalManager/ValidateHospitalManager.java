package com.example.Project_3.security.annotationAuthCustom.hospitalManager;

import com.example.Project_3.entities.role.Role;
import com.example.Project_3.entities.users.User;
import com.example.Project_3.enums.role.RoleEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.stream.Collectors;

public class ValidateHospitalManager implements ConstraintValidator<isHospitalManager, User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getRoles().stream().map(Role::getName).collect(Collectors.toList()).contains(RoleEnum.HOSPITAL_MANAGER.getRoleName());
    }
}
