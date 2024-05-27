package com.example.Project_3.controller.importReceipt;

import com.example.Project_3.dtos.importReceipt.IGetLstImportReceipt;
import com.example.Project_3.dtos.importReceipt.IGetLstImportReceiptALL;
import com.example.Project_3.dtos.importReceipt.ImportReceiptDTO;

import com.example.Project_3.dtos.importReceipt.ImportReceiptListDTO;
import com.example.Project_3.dtos.importReceiptDetail.IGetListImportReceiptDetail;
import com.example.Project_3.dtos.importReceiptDetail.ImportReceiptDetailLstDTO;
import com.example.Project_3.sevice.importReceipt.ImportReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/import-receipt")
public class ImportReceiptController {
    @Autowired
    private ImportReceiptService importReceiptService ;

    @PostMapping("/create")
    public void createImportReceipt(@RequestBody ImportReceiptDTO importReceiptDTO){
        importReceiptService.createImportReceipt(importReceiptDTO);
    }



    @GetMapping("/get-lst")
    public List<IGetLstImportReceipt> getLstImportReceipts (@RequestParam(name = "code",defaultValue = "",required = false) String code ,
                                                            @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                            @RequestParam(name = "startDate", defaultValue = "1970-01-01", required = false) Date startDate,
                                                            @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                @RequestParam(name = "endDate",defaultValue = "1970-01-01",required = false) Date endDate) {
        return importReceiptService.getLstImportReceipt(code,startDate,endDate);
    }
    @GetMapping("/get-lst-detail")
    public List<IGetListImportReceiptDetail> getListImportReceiptDetails(@RequestParam("id") Long importReceiptId){
        return importReceiptService.getListImportReceiptDetail(importReceiptId);
    }




}
