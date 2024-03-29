package com.example.Project_3.repositories.requestReceipt;

import com.example.Project_3.constant.sql.requestReceipt.SQLRequestReceipt;
import com.example.Project_3.dtos.requestReceipt.getList.IGetListRequestReceipt;
import com.example.Project_3.dtos.requestReceipt.getList.IGetRequestReceiptListCode;
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
                                                       @Param("name") String departmentName,
                                                       @Param("status") Integer status );

    @Query(nativeQuery = true,value = SQLRequestReceipt.GET_REQUEST_RECEIPT_CODE)
    List<IGetRequestReceiptListCode> getRequestReceiptCodeList();
}
