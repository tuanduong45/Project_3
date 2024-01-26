package com.example.Project_3.enums.drugGroupStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public enum DrugGroupStatus {
    ACTIVE("Đang sử dụng",1) ,
    UNACTIVE("Không sử dụng",0);


    private String name ;
    private int value;
}
