package com.example.Project_3.dtos.requestReceipt.getList;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DrugListDTO {
    String drugName;
    Long quantity;
    String unitName;
}
