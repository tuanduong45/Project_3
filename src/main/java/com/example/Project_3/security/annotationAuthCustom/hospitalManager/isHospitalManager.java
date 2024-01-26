package com.example.Project_3.security.annotationAuthCustom.hospitalManager;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidateHospitalManager.class)
public @interface isHospitalManager {
    String message() default "user don't have role hospital manager ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
