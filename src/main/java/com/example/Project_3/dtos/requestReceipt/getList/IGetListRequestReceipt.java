package com.example.Project_3.dtos.requestReceipt.getList;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface IGetListRequestReceipt {
    String getRequestReceiptCode();
    String getCreatorName();
    String getDepartmentName();
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    Date getRequestDate();
    String getRequestStatus();
    String getDrugName();
    Long getQuantity();
    String getUnitName();
}
