package com.example.Project_3.enums.importReceiptStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ImportReceiptStatus {

    IMPORTED("Đã nhập kho", 1),
    CANCEL("Đã hủy",0),
    DRAFT("Bản nháp",-1),
    CONFIRMING("Chờ xác nhận",2);


    private String name ;
    private int value;
}
