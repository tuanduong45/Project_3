package com.example.Project_3.dtos.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListDepartment {
    private String get ;
    private String name ;
    private String email ;
    private String phoneNumber;

}
