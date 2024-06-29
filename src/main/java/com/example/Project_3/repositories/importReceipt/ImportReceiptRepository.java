package com.example.Project_3.repositories.importReceipt;

import com.example.Project_3.constant.sql.importReceipt.SQLImportReceipt;
import com.example.Project_3.dtos.importReceipt.IGetInforToReport;
import com.example.Project_3.dtos.importReceipt.IGetLstImportReceipt;
import com.example.Project_3.dtos.importReceiptDetail.IGetListImportReceiptDetail;
import com.example.Project_3.dtos.supplier.IGetSupplierToReport;
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
  /*  @Query(nativeQuery = true,value = SQLImportReceipt.GET_LIST_IMPORT_RECEIPT)
    List<IGetListImportReceipt> getListImportReceiptByCode();

   */
  /*  @Query(nativeQuery = true,value = SQLImportReceipt.GET_LIST_IMPORT_RECEIPT_DETAIL)
    List<IGetLstImportReceiptALL> getListImportReceipt(@Param("code") String code ,
                                                       @Param("date") Date date ,
                                                       @Param("status") String status);

   */

    @Query(nativeQuery = true,value = SQLImportReceipt.GET_LST_IMPORT_RECEIPT)
    List<IGetLstImportReceipt> getLstImportReceipt(@Param("code") String code,
                                                   @Param("startDate") Date startDate,
                                                   @Param("endDate") Date endDate);


    @Query(nativeQuery = true, value = SQLImportReceipt.GET_LST_IMPORT_RECEIPT_DETAIL )
    List<IGetListImportReceiptDetail> getLstImportReceiptDetail(@Param("id") Long importReceiptId);

    @Query(nativeQuery = true,value = SQLImportReceipt.GET_IMPORT_BY_MONTH)
    List<IGetInforToReport> reportImportByMonth(@Param("monthYear") String monthYear);

    @Query(nativeQuery = true,value = SQLImportReceipt.GET_IMPORT_BY_YEAR)
    List<IGetInforToReport> reportImportByYear(@Param("year") String year);

    @Query(nativeQuery = true , value = SQLImportReceipt.GET_IMPORT_BY_DATE)
    List<IGetInforToReport> reportImportByDate(@Param("startDate") Date startDate ,
                                               @Param("endDate") Date endDate);

    @Query(nativeQuery = true , value = SQLImportReceipt.GET_SUPPLIER_REPORT_BY_DATE)
    List<IGetSupplierToReport> reportSupplierByDate (@Param("startDate") Date startDate,
                                                     @Param("endDate") Date endDate);

}
