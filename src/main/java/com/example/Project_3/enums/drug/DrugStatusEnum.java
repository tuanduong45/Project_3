package com.example.Project_3.enums.drug;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DrugStatusEnum {

    ACTIVE (0,"Đang hoạt động"),
    INACTIVE(1,"Không hoạt động"),
    EXPIRED(2,"Hết hạn sử dụng"),
    OUT_OF_STOCK(3,"Hết hàng");



    private final int status ;
    private final String statusText;
}
