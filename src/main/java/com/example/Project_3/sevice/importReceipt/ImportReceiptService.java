package com.example.Project_3.sevice.importReceipt;

import com.example.Project_3.dtos.importReceipt.IGetLstImportReceipt;
import com.example.Project_3.dtos.importReceipt.ImportReceiptDTO;
import com.example.Project_3.dtos.importReceiptDetail.IGetListImportReceiptDetail;
import com.example.Project_3.entities.inventory.Inventory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface ImportReceiptService {
    // thêm hóa đơn nhập bao gồm danh sách chi tiết hóa đơn
    void createImportReceipt(ImportReceiptDTO importReceiptDTO);

    // lấy danh sách hóa đơn nhập
    List<IGetLstImportReceipt> getLstImportReceipt(String code, Date startDate,Date endDate);

    // lấy danh sách đơn thuốc theo id
    List<IGetListImportReceiptDetail> getListImportReceiptDetail(Long id);



}
