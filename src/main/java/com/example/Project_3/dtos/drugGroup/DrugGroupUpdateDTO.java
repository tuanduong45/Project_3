package com.example.Project_3.dtos.drugGroup;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.AnyKeyJavaClass;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugGroupUpdateDTO {

    private String drugGroupName;

    private String drugGroupDescribe;
}
