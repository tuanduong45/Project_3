package com.example.Project_3.dtos.importReceipt;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
// lấy dữ liệu tất cả hóa đơn nhập và chi tiết hóa đơn của mỗi hóa đơn đó
public interface IGetLstImportReceiptALL {
    String getImportReceiptCode();
    String getImportPersonName();
    @JsonFormat(pattern = "yyyy-MM-dd" , timezone = "Asia/Ho_Chi_Minh")
    Date getImportDate();
    String getStatus();
    String getDrugName();
    String getSupplierName();
    String getProduceBatchNumber();
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Ho_Chi_Minh")
    Date getExpiryDate();
    String getUnitName();
    Long getPrice();
    Long getTotalAmount();
    Long getQuantity();
}
