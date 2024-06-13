package com.example.Project_3.controller.requestReceipt;

import com.example.Project_3.dtos.common.ICommonIdCodeName;
import com.example.Project_3.dtos.requestReceipt.create.RequestReceiptCreateDTO;

import com.example.Project_3.dtos.requestReceipt.getList.IGetComonDrugIdQuantity;
import com.example.Project_3.dtos.requestReceipt.getList.IGetListRequestReceipt;
import com.example.Project_3.dtos.requestReceipt.getList.IGetRequestReceiptListDrug;

import com.example.Project_3.enums.requestStatus.RequestStatus;
import com.example.Project_3.sevice.requestReceipt.RequestReceiptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/request-receipt")
public class RequestReceiptController {
    @Autowired
    private RequestReceiptService requestReceiptService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER')" +
            "or hasAuthority('ROLE_DEPARTMENT_NURSING')")
    public void createRequestReceipt(@RequestBody RequestReceiptCreateDTO createDTO) {
        requestReceiptService.createRequestReceipt(createDTO);
    }

    @GetMapping("/get-list")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER')" +
            "or hasAuthority('ROLE_DEPARTMENT_NURSING') " +
            "or hasAuthority('ROLE_PHARMACY_STOCKER') " +
            "or hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') " +
            "or hasAuthority('ROLE_HOSPITAL_MANAGER')")
    public List<IGetListRequestReceipt> getRequestReceiptList(@RequestParam(value = "requestCode", defaultValue = "", required = false) String requestCode,
                          @DateTimeFormat(pattern = "yyyy-MM-dd")
                          @RequestParam(value = "startDate", defaultValue = "1970-01-01", required = false) Date startDate,
                          @DateTimeFormat(pattern = "yyyy-MM-dd")
                          @RequestParam(value = "endDate", defaultValue = "1970-01-01", required = false) Date endDate,
                          @RequestParam(value = "status", defaultValue = "ALL", required = false) RequestStatus status) {
        return requestReceiptService.getRequestReceiptDetailList(requestCode, startDate, endDate,status);
    }

    @GetMapping("/get-list-drug")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER')" +
            "or hasAuthority('ROLE_DEPARTMENT_NURSING') " +
            "or hasAuthority('ROLE_PHARMACY_STOCKER') " +
            "or hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') " +
            "or hasAuthority('ROLE_HOSPITAL_MANAGER')")
    public List<IGetRequestReceiptListDrug> getListDrugByRequestReceiptId(@RequestParam(value = "id") Long requestReceiptId){
        return requestReceiptService.getListDrugRequestReceiptId(requestReceiptId);
    }

    @GetMapping("/get-list-drug-from-inventory")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_MANAGER')" +
            "or hasAuthority('ROLE_DEPARTMENT_NURSING')")
    public List<ICommonIdCodeName> getListDrugFromInventory(){
        return requestReceiptService.getListDrugFromInventory();
    }
    @GetMapping("/confirm-receipt")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') ")
    public void confirmRequestReceipt(@RequestParam("id") Long requestReceiptId) {
        requestReceiptService.confirmRequestReceipt(requestReceiptId);
    }

    @GetMapping("/reject-receipt")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') ")
    public void rejectRequestReceipt(@RequestParam("id") Long requestReceiptId) {
        requestReceiptService.rejectRequestReceipt(requestReceiptId);
    }

}
