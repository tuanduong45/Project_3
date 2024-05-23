package com.example.Project_3.dtos.drug;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DrugUpdateDTO {
     String name;
     String drugInteraction;
     String contraindication;
     String price;
     String usage;
     String dosage;
     Long unitId;
    // Long drugGroupId;

}
