package com.example.Project_3.dtos.importReceipt;

import java.util.Date;
// lấy dữ liệu hóa đơn nhập từ query
public interface IGetListImportReceipt {
    String getImportReceiptCode();
    String getImportPersonName();
    String getStatus();
    Date getImportDate();
}
