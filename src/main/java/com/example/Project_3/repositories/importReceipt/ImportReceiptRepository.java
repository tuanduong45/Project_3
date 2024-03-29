package com.example.Project_3.repositories.importReceipt;

import com.example.Project_3.constant.sql.importReceipt.SQLImportReceipt;
import com.example.Project_3.constant.sql.requestReceipt.SQLRequestReceipt;
import com.example.Project_3.dtos.importReceipt.IGetListImportReceipt;
import com.example.Project_3.dtos.importReceipt.IGetLstImportReceiptALL;
import com.example.Project_3.dtos.requestReceipt.getList.IGetRequestReceiptListCode;
import com.example.Project_3.entities.importReceipt.ImportReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ImportReceiptRepository extends JpaRepository<ImportReceipt,Long> {

    Boolean existsByImportReceiptCode(String code);
    // lấy danh sách mã phiếu nhập kho
    @Query(nativeQuery = true,value = SQLImportReceipt.GET_LIST_IMPORT_RECEIPT)
    List<IGetListImportReceipt> getListImportReceiptByCode();
    @Query(nativeQuery = true,value = SQLImportReceipt.GET_LIST_IMPORT_RECEIPT_DETAIL)
    List<IGetLstImportReceiptALL> getListImportReceipt(@Param("code") String code ,
                                                       @Param("date") Date date ,
                                                       @Param("status") String status);

}
