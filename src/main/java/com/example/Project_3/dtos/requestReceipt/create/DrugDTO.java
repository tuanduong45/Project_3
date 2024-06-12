package com.example.Project_3.dtos.requestReceipt.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugDTO {
    Long drugId;
    Long quantity ;
    Long unitId;
}
