package com.example.Project_3.dtos.unit;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnitUpdateDTO {
    String unitName;
    Long conversionRule;
    String unitCharacteristic;

}
