package com.example.Project_3.dtos.importReceipt;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface IGetLstImportReceipt {
    Long getId();
    String getImportReceiptCode();
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",timezone = "Asia/Ho_Chi_Minh")
    Date getImportDate();
    String getCreatedBy();
    String getStatusText();
}
