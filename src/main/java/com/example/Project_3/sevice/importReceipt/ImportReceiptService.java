package com.example.Project_3.sevice.importReceipt;

import com.example.Project_3.dtos.importReceipt.ImportReceiptDTO;
import org.springframework.stereotype.Service;

@Service
public interface ImportReceiptService {

    void createImportReceipt(ImportReceiptDTO importReceiptDTO);
}
