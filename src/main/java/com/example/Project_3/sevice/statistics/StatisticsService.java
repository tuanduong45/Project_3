package com.example.Project_3.sevice.statistics;

import com.example.Project_3.dtos.importReceipt.IGetInforToReport;
import com.example.Project_3.dtos.inventory.IGetInventoryReport;
import com.example.Project_3.dtos.inventory.IGetListSummarizeReport;
import com.example.Project_3.dtos.requestReceipt.getList.IGetInforReport;
import com.example.Project_3.dtos.supplier.IGetSupplierToReport;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface StatisticsService {



    List<IGetInforReport> reportRequestReceiptByDate(Date startDate, Date endDate);

    List<IGetInforToReport> reportImportByDate(Date startDate,Date endDate);

    List<IGetSupplierToReport> reportSupplierByDate(Date startDate,Date endDate);

    List<IGetInventoryReport> reportInventory();

    List<IGetListSummarizeReport> getSummarizeReport(Date startDate, Date endDate);

}
