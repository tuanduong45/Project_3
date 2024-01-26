package com.example.Project_3.dtos.department;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentCreateDTO {
    @NotNull
    private String code ;
    @NotNull
    private String name ;
    private String email ;
    private String phoneNumber ;
    private String address ;


}
