package com.example.Project_3.sevice.statistics.impl;

import com.example.Project_3.dtos.importReceipt.IGetInforToReport;
import com.example.Project_3.dtos.inventory.IGetInventoryReport;
import com.example.Project_3.dtos.inventory.IGetListSummarizeReport;
import com.example.Project_3.dtos.requestReceipt.getList.IGetInforReport;
import com.example.Project_3.dtos.supplier.IGetSupplierToReport;
import com.example.Project_3.repositories.importReceipt.ImportReceiptRepository;
import com.example.Project_3.repositories.inventory.InventoryRepository;
import com.example.Project_3.repositories.requestReceipt.RequestReceiptRepository;
import com.example.Project_3.sevice.statistics.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private ImportReceiptRepository importReceiptRepository;
    @Autowired
    private RequestReceiptRepository requestReceiptRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<IGetInforReport> reportRequestReceiptByDate(Date startDate, Date endDate) {
        return requestReceiptRepository.reportRequestReceiptByDate(startDate,endDate);
    }

    @Override
    public List<IGetInforToReport> reportImportByDate(Date startDate, Date endDate) {
        return importReceiptRepository.reportImportByDate(startDate , endDate );
    }

    @Override
    public List<IGetSupplierToReport> reportSupplierByDate(Date startDate, Date endDate) {
        return importReceiptRepository.reportSupplierByDate(startDate,endDate);
    }

    @Override
    public List<IGetInventoryReport> reportInventory() {
        return inventoryRepository.inventoryReport();
    }

    @Override
    public List<IGetListSummarizeReport> getSummarizeReport(Date startDate, Date endDate) {
        return inventoryRepository.getSummarizeReport(startDate,endDate);
    }
}
