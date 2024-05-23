package com.example.Project_3.enums.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SupplierStatusEnum {

    NEW(0,"Mới thêm"),
    ACTIVE(1,"Đang hoạt động"),
    INACTIVE(2,"Ngừng hợp tác");



    private final int status ;
    private final String statusText;
}
