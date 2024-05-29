package com.example.Project_3.dtos.importReceiptDetail;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;

import java.util.Date;

public interface IGetListImportReceiptDetail {

    Long getDrugId();
    String getDrugCode();
    String getDrugName();
    String getSupplierName();
    String getProduceBatchNumber();
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",timezone = "Asia/Ho_Chi_Minh")
    Date getExpiryDate();
    Long getQuantity();
    String getPrice();
    Long getTotalAmount();
    String getUnitName();

}
