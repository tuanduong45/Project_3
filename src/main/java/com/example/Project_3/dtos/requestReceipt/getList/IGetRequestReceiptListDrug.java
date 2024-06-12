package com.example.Project_3.dtos.requestReceipt.getList;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface IGetRequestReceiptListDrug {
    String getDrugCode();
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd/MM/yyyy",timezone = "Asia/Ho_Chi_Minh")
    Date getExpiryDate();
    String getDrugName();
    String getUnitName();
    Long getQuantity();
}
