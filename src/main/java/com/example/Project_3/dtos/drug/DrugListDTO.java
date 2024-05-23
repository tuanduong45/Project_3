package com.example.Project_3.dtos.drug;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugListDTO {
    Long id ;
    String drugGroupName;
    String code;
    String name;
    String registrationNumber;
    String unitName;
    String usage;
    String dosageForm;
    String activeSubstance;
    String price;
    String produceCountry;
    String dosage;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "YYYY-MM-DD")
    Date expiryDate;
    String content;
    String packing;
    String drugInteraction;
    String contraindication;
    String drugStatus;

}
