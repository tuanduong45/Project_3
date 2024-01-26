package com.example.Project_3.dtos.department;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentUpdateDTO {
    @NotNull
    private String name ;
    private String email;
    private String phoneNumber ;
    private String address ;

}
