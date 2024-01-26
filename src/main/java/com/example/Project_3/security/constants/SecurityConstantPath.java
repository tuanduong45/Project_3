package com.example.Project_3.security.constants;

import lombok.Data;

@Data
public class SecurityConstantPath {
        public static final String[] LIST_ROLE_HOSPITAL_MANAGER = {"/department/**","/user/**"};
        public static final String[] LIST_ROLE_DEPARTMENT_MANAGER = {"/department/update/**","/department/getList/**"};

}
