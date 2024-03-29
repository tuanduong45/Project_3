package com.example.Project_3.enums.requestStatus;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public enum RequestStatus {
    ALL(-1 , "Tất cả"),
    PROCESSING(1,"Đang xử lý"),
    CANCELED(2,"Đã hủy "),
    COMPLETE(3,"Hoàn thành");

    private final Integer value;
    private final String name;
}
