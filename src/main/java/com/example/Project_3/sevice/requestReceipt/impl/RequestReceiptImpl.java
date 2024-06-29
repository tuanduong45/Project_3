package com.example.Project_3.sevice.requestReceipt.impl;

import com.example.Project_3.constant.message.errorKey.ErrorKey;
import com.example.Project_3.constant.message.messageConst.MessageConst;
import com.example.Project_3.dtos.common.ICommonIdCodeName;
import com.example.Project_3.dtos.inventory.IGetListInventoryMinExMaxQuantity;
import com.example.Project_3.dtos.requestReceipt.create.RequestReceiptCreateDTO;
import com.example.Project_3.dtos.requestReceipt.getList.IGetComonDrugIdQuantity;
import com.example.Project_3.dtos.requestReceipt.getList.IGetInforReport;
import com.example.Project_3.dtos.requestReceipt.getList.IGetListRequestReceipt;
import com.example.Project_3.dtos.requestReceipt.getList.IGetRequestReceiptListDrug;
import com.example.Project_3.entities.drug.DrugRequestReceipt;
import com.example.Project_3.entities.requestReceipt.RequestReceipt;
import com.example.Project_3.enums.requestStatus.RequestStatus;
import com.example.Project_3.exceptions.exceptionFactory.ExceptionFactory;
import com.example.Project_3.repositories.drugRequestReceipt.DrugRequestReceiptRepository;
import com.example.Project_3.repositories.inventory.InventoryRepository;
import com.example.Project_3.repositories.requestReceipt.RequestReceiptRepository;
import com.example.Project_3.repositories.user.UserRepository;
import com.example.Project_3.sevice.requestReceipt.RequestReceiptService;
import com.example.Project_3.utils.auth.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RequestReceiptImpl implements RequestReceiptService {
    @Autowired
    private RequestReceiptRepository requestReceiptRepository;
    @Autowired
    private DrugRequestReceiptRepository drugRequestReceiptRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ExceptionFactory exceptionFactory ;

    @Override
    public void createRequestReceipt(RequestReceiptCreateDTO receiptCreateDTO) {
        RequestReceipt createDTO = new RequestReceipt();
        createDTO.setRequestDate(new Date());
        createDTO.setRequestReceiptCode(generateUserCode());
        createDTO.setRequestStatus(RequestStatus.PROCESSING.getValue());
        createDTO.setUser(AuthUtils.getCurrentUser());
        Long requestReceiptId = requestReceiptRepository.save(createDTO).getId();
        Set<DrugRequestReceipt> drugRequestReceipts = receiptCreateDTO.getDrugDTOS().stream()
                .map(value -> new DrugRequestReceipt(value.getDrugId(), requestReceiptId,
                        value.getQuantity(), value.getUnitId())).collect(Collectors.toSet());

        drugRequestReceiptRepository.saveAll(drugRequestReceipts);
    }

    @Override
    public List<IGetListRequestReceipt> getRequestReceiptDetailList(String requestCode, Date startDate,
                                                                    Date endDate,RequestStatus status) {

        return requestReceiptRepository.getListRequestReceipt(requestCode,startDate,endDate,status.getValue());

    }

    @Override
    public List<IGetRequestReceiptListDrug> getListDrugRequestReceiptId(Long requestReceiptId) {
        return requestReceiptRepository.getListDrugByRequestReceiptId(requestReceiptId);
    }

    @Override
    public List<ICommonIdCodeName> getListDrugFromInventory() {
        return requestReceiptRepository.getListDrugFromInventory();
    }

    @Override
    public void confirmRequestReceipt(Long requestReceiptId) {
        Optional<RequestReceipt> requestReceipt = requestReceiptRepository.findById(requestReceiptId);
        if(!requestReceipt.isPresent()){
            throw exceptionFactory.resourceNotFoundException(ErrorKey.RequestReceipt.NOT_FOUND_ERROR_CODE, MessageConst.RESOURCE_NOT_FOUND,
                    MessageConst.Resources.REQUEST_RECEIPT,ErrorKey.RequestReceipt.ID);
        } else {

            List<IGetComonDrugIdQuantity> idQuantity = getDrugIdQuantityOfRequestReceipt(requestReceiptId);
            // duyệt qua các thuốc và số lượng của phiếu
            for (IGetComonDrugIdQuantity idQuantity1 : idQuantity){
                List<IGetListInventoryMinExMaxQuantity> inventoryMinExMaxQuantities =
                        inventoryRepository.getDrugMinExpiryMaxQuantityByDrugId(idQuantity1.getDrugId());
                // biến lưu số thuốc còn lại
                long remainQuantity = idQuantity1.getQuantity();
                // duyệt qua các lô thuốc của thuốc của phiếu đó
                for(IGetListInventoryMinExMaxQuantity exMaxQuantity : inventoryMinExMaxQuantities) {
                    // nếu thuốc của phiếu > lô thuốc trong kho thì trừ đi lô thuốc trong kho và set lô thuốc trong kho đó bằng 0
                    // và tiếp tục đến lô thuốc tiếp theo và remain bây h bằng ban đầu trừ đi lô thuốc đã lấy
                    if (remainQuantity >= exMaxQuantity.getQuantity()) {
                         remainQuantity = remainQuantity - exMaxQuantity.getQuantity();
                        inventoryRepository.updateQuantity(exMaxQuantity.getProduceBatchNumber(), 0L);
                    } else {
                        // nếu thuốc của phiếu < lô thuốc trong kho thì set lô thuốc trong kho bằng lô thuốc trong kho trừ đi
                        // lô thuốc của phiếu và thoát vòng lặp
                         remainQuantity = exMaxQuantity.getQuantity() - remainQuantity;
                        inventoryRepository.updateQuantity(exMaxQuantity.getProduceBatchNumber(), remainQuantity);
                        break;
                    }
                }
            }

            requestReceipt.get().setRequestStatus(RequestStatus.COMPLETE.getValue());
            requestReceiptRepository.save(requestReceipt.get());
        }
    }

    @Override
    public void rejectRequestReceipt(Long requestReceiptId) {
        Optional<RequestReceipt> requestReceipt = requestReceiptRepository.findById(requestReceiptId);
        if(!requestReceipt.isPresent()){
            throw exceptionFactory.resourceNotFoundException(ErrorKey.RequestReceipt.NOT_FOUND_ERROR_CODE, MessageConst.RESOURCE_NOT_FOUND,
                    MessageConst.Resources.REQUEST_RECEIPT,ErrorKey.RequestReceipt.ID);
        } else {
            requestReceipt.get().setRequestStatus(RequestStatus.CANCELED.getValue());
            requestReceiptRepository.save(requestReceipt.get());
        }
    }



    // lấy drugid và quantity bằng request receipt id
    public List<IGetComonDrugIdQuantity> getDrugIdQuantityOfRequestReceipt(Long requestReceiptId) {
        return requestReceiptRepository.getDrugIdQuantityOfRequestReceipt(requestReceiptId);
    }


    public String generateUserCode() {
        String baseCode = "PYC";
        Random random = new Random();
        String generatedCode = baseCode + (random.nextInt(100000) + 100000);
        while (requestReceiptRepository.existsByRequestReceiptCode(generatedCode)) {
            generatedCode = baseCode + (random.nextInt(100000) + 100000);
        }
        return generatedCode;

    }
}
