package com.example.Project_3.sevice.importReceipt;

import com.example.Project_3.dtos.importReceipt.IGetLstImportReceipt;
import com.example.Project_3.dtos.importReceipt.ImportReceiptDTO;
import com.example.Project_3.dtos.importReceipt.ImportReceiptListDTO;
import com.example.Project_3.dtos.importReceiptDetail.IGetListImportReceiptDetail;
import com.example.Project_3.dtos.importReceiptDetail.ImportReceiptDetailLstDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface ImportReceiptService {
    // thêm hóa đơn nhập bao gồm danh sách chi tiết hóa đơn
    void createImportReceipt(ImportReceiptDTO importReceiptDTO);
    // lấy ra danh sách bao gồm cả hóa đơn nhập và danh sách chi tiết hóa đơn ứng với mỗi hóa đơn nhập
  /*  List<Map<ImportReceiptListDTO,List<ImportReceiptDetailLstDTO>>> getListImportReceipt (String code,
                                                                                          Date date,
                                                                                          String status);

   */

    List<IGetLstImportReceipt> getLstImportReceipt(String code, Date startDate,Date endDate);

    List<Map<ImportReceiptListDTO,List<IGetListImportReceiptDetail>>> getLstImportReceiptAll(String code ,
                                                                                             Date startDate,
                                                                                             Date endDate) ;

    List<IGetListImportReceiptDetail> getListImportReceiptDetail(Long id);

}
