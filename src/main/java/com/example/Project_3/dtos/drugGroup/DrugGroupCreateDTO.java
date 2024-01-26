package com.example.Project_3.dtos.drugGroup;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugGroupCreateDTO {
    @NotNull
    private String drugGroupName;
    @NotNull
    private String drugGroupDescribe;
}
