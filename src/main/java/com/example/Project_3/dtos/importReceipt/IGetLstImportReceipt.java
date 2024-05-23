package com.example.Project_3.dtos.importReceipt;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface IGetLstImportReceipt {
    Long getId();
    String getImportReceiptCode();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date getImportDate();
    String getCreatedBy();
    String getStatusText();
}
