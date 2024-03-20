package com.example.Project_3.controller.importReceipt;

import com.example.Project_3.dtos.importReceipt.ImportReceiptDTO;
import com.example.Project_3.sevice.importReceipt.ImportReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/importReceipt")
public class ImportReceiptController {
    @Autowired
    private ImportReceiptService importReceiptService ;

    @PostMapping("/create")
    public void createImportReceipt(@RequestBody ImportReceiptDTO importReceiptDTO){
        importReceiptService.createImportReceipt(importReceiptDTO);
    }
}
