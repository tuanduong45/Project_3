package com.example.Project_3.enums.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum UserStatusEnum {
    ACTIVE(0, "Đang hoạt động"),
    INACTIVE(1, "Tạm dừng hoạt động");


    private final Integer status;
    private final String statusText;
}
