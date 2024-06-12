package com.example.Project_3.dtos.requestReceipt.getList;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface IGetListRequestReceipt {
    Long getId();
    String getRequestReceiptCode();
    String getCreatorName();
    String getDepartmentName();
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",timezone = "Asia/Ho_Chi_Minh")
    Date getRequestDate();
    String getRequestStatus();

}
