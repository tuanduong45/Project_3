package com.example.Project_3.sevice.requestReceipt;

import com.example.Project_3.dtos.common.ICommonIdCodeName;
import com.example.Project_3.dtos.requestReceipt.create.RequestReceiptCreateDTO;

import com.example.Project_3.dtos.requestReceipt.getList.IGetComonDrugIdQuantity;
import com.example.Project_3.dtos.requestReceipt.getList.IGetInforReport;
import com.example.Project_3.dtos.requestReceipt.getList.IGetListRequestReceipt;
import com.example.Project_3.dtos.requestReceipt.getList.IGetRequestReceiptListDrug;
import com.example.Project_3.enums.requestStatus.RequestStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface RequestReceiptService {

    void createRequestReceipt(RequestReceiptCreateDTO receiptCreateDTO);

    List<IGetListRequestReceipt> getRequestReceiptDetailList(String requestCode, Date startDate,
                                                             Date endDate, RequestStatus status );

    List<IGetRequestReceiptListDrug> getListDrugRequestReceiptId(Long requestReceiptId);

    // lấy danh sách thuốc từ kho
    List<ICommonIdCodeName> getListDrugFromInventory();

    // xác nhận đơn yêu cầu thuốc

    void confirmRequestReceipt(Long requestReceiptId);
    // từ chối đơn yêu caauf thuốc
    void rejectRequestReceipt(Long requestReceiptId);






}
