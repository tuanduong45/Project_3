package com.example.Project_3.dtos.drug;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugListDTO {
    String drugGroupName;
    String code;
    String name;
    String registrationNumber;
    String unitName;
    String usage;
    String groupCode;
    String activeSubstance;
    String price;
    String produceCountry;

}
