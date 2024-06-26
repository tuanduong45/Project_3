package com.example.Project_3.repositories.requestReceipt;

import com.example.Project_3.constant.sql.requestReceipt.SQLRequestReceipt;
import com.example.Project_3.dtos.common.ICommonIdCodeName;
import com.example.Project_3.dtos.requestReceipt.getList.IGetComonDrugIdQuantity;
import com.example.Project_3.dtos.requestReceipt.getList.IGetInforReport;
import com.example.Project_3.dtos.requestReceipt.getList.IGetListRequestReceipt;
import com.example.Project_3.dtos.requestReceipt.getList.IGetRequestReceiptListDrug;
import com.example.Project_3.entities.requestReceipt.RequestReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RequestReceiptRepository extends JpaRepository<RequestReceipt,Long> {
    boolean existsByRequestReceiptCode(String code);
    @Query(nativeQuery = true , value = SQLRequestReceipt.GET_LIST_REQUEST_RECEIPT)
    List<IGetListRequestReceipt> getListRequestReceipt(@Param("code") String requestCode,
                                                       @Param("startDate") Date startDate,
                                                       @Param("endDate") Date endDate,
                                                       @Param("status") Integer status );

    @Query(nativeQuery = true,value = SQLRequestReceipt.GET_LIST_DRUG_BY_REQUEST_RECEIPT_ID)
    List<IGetRequestReceiptListDrug> getListDrugByRequestReceiptId(@Param("id") Long requestReceiptId);

    @Query(nativeQuery = true,value = SQLRequestReceipt.GET_LIST_DRUG_FROM_INVENTORY)
    List<ICommonIdCodeName> getListDrugFromInventory();

    @Query(nativeQuery = true , value = SQLRequestReceipt.GET_DRUG_ID_AND_QUANTITY)
    List<IGetComonDrugIdQuantity> getDrugIdQuantityOfRequestReceipt(@Param("id") Long requestReceiptId);

    @Query(nativeQuery = true,value = SQLRequestReceipt.GET_REPORT_BY_DATE)
    List<IGetInforReport> reportRequestReceiptByDate(@Param("startDate") Date startDate
            ,@Param("endDate") Date endDate);
}
