package com.example.Project_3.dtos.requestReceipt.getList;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface IGetRequestReceiptListCode {
    String getRequestReceiptCode();
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd")
    Date getRequestDate();
    String getCreatorName();
    String getDepartmentName();
    String getRequestStatus();
}
