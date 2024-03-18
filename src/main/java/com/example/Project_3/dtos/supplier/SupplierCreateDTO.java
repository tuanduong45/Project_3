package com.example.Project_3.dtos.supplier;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class SupplierCreateDTO {
    String name;
    String address;
    String phoneNumber;
    String email;
    String taxCode;
    String representativeName;

}
