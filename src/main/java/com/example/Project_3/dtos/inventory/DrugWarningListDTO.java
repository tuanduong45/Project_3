package com.example.Project_3.dtos.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugWarningListDTO {
    private Long drugId;
    List<DrugWarningDTO> drugWarningDTOS ;
}
