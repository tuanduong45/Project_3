package com.example.Project_3.dtos.user;

import com.example.Project_3.enums.identityType.IdentityTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDTO {
    private String identificationNumber;
    private String identityTypeName;
    @NotNull
    private String firstName;
    @NotBlank
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd")
    private Date birthDate;
    @NotNull
    private String phoneNumber;
    private String email;
    private Set<Long> lstRoleId = new HashSet<>();
    @NotNull
    private Long departmentID;

}
