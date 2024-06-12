package com.example.Project_3.dtos.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugWarningDTO {
    private String produceBatchNumber;
    private Long expiryBeforeDay;
}
