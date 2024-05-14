package com.example.Project_3.controller.requestReceipt;

import com.example.Project_3.dtos.requestReceipt.create.RequestReceiptCreateDTO;
import com.example.Project_3.dtos.requestReceipt.getList.DrugListDTO;
import com.example.Project_3.dtos.requestReceipt.getList.RequestReceiptGetListDTO;
import com.example.Project_3.enums.requestStatus.RequestStatus;
import com.example.Project_3.sevice.requestReceipt.RequestReceiptService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/requestReceipt")
public class RequestReceiptController {
    @Autowired
    private RequestReceiptService requestReceiptService;

    @PostMapping("/create")
    public void createRequestReceipt(@RequestBody RequestReceiptCreateDTO createDTO) {
        requestReceiptService.createRequestReceipt(createDTO);
    }

    @GetMapping("/getList")
    public List<Map<RequestReceiptGetListDTO, List<DrugListDTO>>>
    getRequestReceiptList(@RequestParam(value = "requestCode", defaultValue = "", required = false) String requestCode,
                          @DateTimeFormat(pattern = "yyyy-MM-dd")
                          @RequestParam(value = "startDate", defaultValue = "1970-01-01", required = false) Date startDate,
                          @DateTimeFormat(pattern = "yyyy-MM-dd")
                          @RequestParam(value = "endDate", defaultValue = "1970-01-01", required = false) Date endDate,
                          @RequestParam(value = "status", defaultValue = "ALL", required = false) RequestStatus status,
                          @RequestParam(value = "departmentName", defaultValue = "", required = false) String departmentName) {
        return requestReceiptService.getRequestReceiptDetailList(requestCode, startDate, endDate, departmentName,status);
    }
}