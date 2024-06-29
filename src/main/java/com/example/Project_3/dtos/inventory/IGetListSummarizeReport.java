package com.example.Project_3.dtos.inventory;

public interface IGetListSummarizeReport {
    String getDrugName();
    Long getImportQuantity();
    Long getExportQuantity();
    Long getInventoryQuantity();
    Long getTotal();
    String getUnitName();
}
