package com.example.Project_3.controller.statistic;

import com.example.Project_3.dtos.importReceipt.IGetInforToReport;
import com.example.Project_3.dtos.inventory.IGetInventoryReport;
import com.example.Project_3.dtos.inventory.IGetListSummarizeReport;
import com.example.Project_3.dtos.requestReceipt.getList.IGetInforReport;
import com.example.Project_3.dtos.supplier.IGetSupplierToReport;
import com.example.Project_3.sevice.statistics.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/statistics")
@PreAuthorize("hasAuthority('ROLE_MEDICINE_STATISTIC') or hasAuthority('ROLE_PHARMACY_STOCKER') " +
        "or hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') or hasAuthority('ROLE_HOSPITAL_MANAGER') ")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService ;

    @GetMapping("/report-import-by-date")
    public List<IGetInforToReport> reportImportByMonth(@RequestParam(value = "startDate")
                                                           @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate ,
                                                       @RequestParam(value = "endDate")
                                                       @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return statisticsService.reportImportByDate(startDate,endDate);
    }

    @GetMapping("/report-request-by-date")
    public List<IGetInforReport> reportRequestReceiptByDate(@RequestParam(value = "startDate")
                                                                @DateTimeFormat(pattern = "yyyy-MM-dd")  Date startDate,
                                                            @RequestParam(value = "endDate")
                                                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return statisticsService.reportRequestReceiptByDate(startDate,endDate);
    }

    @GetMapping ("/report-supplier-by-date")
    public List<IGetSupplierToReport> reportSupplierByDate(@RequestParam(value = "startDate")
                                                               @DateTimeFormat(pattern = "yyyy-MM-dd")  Date startDate,
                                                           @RequestParam(value = "endDate")
                                                               @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return statisticsService.reportSupplierByDate(startDate,endDate);
    }
    @GetMapping("/report-inventory")
    public List<IGetInventoryReport> reportInventory(){
        return statisticsService.reportInventory();
    }

    @GetMapping("/summarize-report")
    public List<IGetListSummarizeReport> getListSummarizeReports (@RequestParam (value = "startDate" , defaultValue = "1970-01-01",required = false )
                                                                  @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate ,
                                                                  @RequestParam(value = "endDate",defaultValue = "1970-01-01",required = false)
                                                                  @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return statisticsService.getSummarizeReport(startDate,endDate);
    }

}
