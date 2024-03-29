package com.example.Project_3.dtos.requestReceipt.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugDTO {
    Long drugID;
    Long quantity ;
    Long unitID;

}
