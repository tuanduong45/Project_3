package com.example.Project_3.sevice.requestReceipt.impl;

import com.example.Project_3.dtos.requestReceipt.create.RequestReceiptCreateDTO;
import com.example.Project_3.dtos.requestReceipt.getList.DrugListDTO;
import com.example.Project_3.dtos.requestReceipt.getList.IGetListRequestReceipt;
import com.example.Project_3.dtos.requestReceipt.getList.IGetRequestReceiptListCode;
import com.example.Project_3.dtos.requestReceipt.getList.RequestReceiptGetListDTO;
import com.example.Project_3.entities.drug.DrugImportReceipt;
import com.example.Project_3.entities.drug.DrugRequestReceipt;
import com.example.Project_3.entities.requestReceipt.RequestReceipt;
import com.example.Project_3.entities.users.User;
import com.example.Project_3.enums.requestStatus.RequestStatus;
import com.example.Project_3.repositories.department.DepartmentRepository;
import com.example.Project_3.repositories.drugRequestReceipt.DrugRequestReceiptRepository;
import com.example.Project_3.repositories.requestReceipt.RequestReceiptRepository;
import com.example.Project_3.repositories.user.UserRepository;
import com.example.Project_3.sevice.requestReceipt.RequestReceiptService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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


    @Override
    public void createRequestReceipt(RequestReceiptCreateDTO receiptCreateDTO) {
        RequestReceipt createDTO = new RequestReceipt();
        createDTO.setRequestDate(new Date());
        createDTO.setRequestReceiptCode(generateUserCode());
        createDTO.setRequestStatus(RequestStatus.PROCESSING.getValue());
        Optional<User> user = userRepository.findById(receiptCreateDTO.getUserId());
        createDTO.setUser(user.get());
        Long requestReceiptId = requestReceiptRepository.save(createDTO).getId();
        Set<DrugRequestReceipt> drugRequestReceipts = receiptCreateDTO.getDrugDTOS().stream()
                .map(value -> new DrugRequestReceipt(value.getDrugID(), requestReceiptId,
                        value.getQuantity(), value.getUnitID())).collect(Collectors.toSet());
        drugRequestReceiptRepository.saveAll(drugRequestReceipts);
    }

    @Override
    public List<Map<RequestReceiptGetListDTO, List<DrugListDTO>>> getRequestReceiptDetailList(String requestCode, Date startDate, Date endDate,
                                                                                              String departmentName,RequestStatus status) {
        List<Map<RequestReceiptGetListDTO, List<DrugListDTO>>> mapList = new ArrayList<>();
        List<IGetListRequestReceipt> listRequestReceipts = requestReceiptRepository.getListRequestReceipt(requestCode, startDate,
                endDate, departmentName ,status.getValue());
        List<IGetRequestReceiptListCode> listCodes = requestReceiptRepository.getRequestReceiptCodeList();

        for (IGetRequestReceiptListCode code : listCodes) {
            Map<RequestReceiptGetListDTO, List<DrugListDTO>> map = new HashMap<>();
            List<DrugListDTO> drugListDTOS = new ArrayList<>();
            RequestReceiptGetListDTO receiptGetListDTO = new RequestReceiptGetListDTO();
            BeanUtils.copyProperties(code, receiptGetListDTO);
            for (IGetListRequestReceipt listRequestReceipt : listRequestReceipts) {
                if (listRequestReceipt.getRequestReceiptCode().equals(code.getRequestReceiptCode())) {
                    DrugListDTO drugListDTO = new DrugListDTO();
                    BeanUtils.copyProperties(listRequestReceipt, drugListDTO);
                    drugListDTOS.add(drugListDTO);
                }
            }
            map.put(receiptGetListDTO, drugListDTOS);
            mapList.add(map);
        }
        return mapList;


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
