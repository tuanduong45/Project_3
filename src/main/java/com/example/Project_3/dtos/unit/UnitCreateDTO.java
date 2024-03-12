package com.example.Project_3.dtos.unit;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnitCreateDTO {
    String unitName;
    Long conversionRule;
    String unitCharacteristic;
    String unitMeasure;
}
