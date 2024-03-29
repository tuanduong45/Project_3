package com.example.Project_3.sevice.requestReceipt;

import com.example.Project_3.dtos.requestReceipt.create.RequestReceiptCreateDTO;
import com.example.Project_3.dtos.requestReceipt.getList.DrugListDTO;
import com.example.Project_3.dtos.requestReceipt.getList.RequestReceiptGetListDTO;
import com.example.Project_3.enums.requestStatus.RequestStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface RequestReceiptService {

    void createRequestReceipt(RequestReceiptCreateDTO receiptCreateDTO);

    List<Map<RequestReceiptGetListDTO, List<DrugListDTO>>> getRequestReceiptDetailList(String requestCode, Date startDate, Date endDate,
                                                                                       String departmentName , RequestStatus status );

}
