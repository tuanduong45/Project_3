package com.example.Project_3.dtos.user;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface IGetListUser {
    String getCode();
    Long getId();
    String getName();
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd")
    Date getBirthDate();
    String getPhoneNumber();
    String getEmail();
    String getIdentityType();
    String getIdentificationNumber();
    String getDepartmentName();
}
