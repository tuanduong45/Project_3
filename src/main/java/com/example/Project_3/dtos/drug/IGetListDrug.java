package com.example.Project_3.dtos.drug;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface IGetListDrug {
    Long getId();
    String getDrugGroupName();
    String getCode();
    String getName();
    String getRegistrationNumber();
    String getUnitName();
    String getUsage();
    String getDosageForm();
    String getActiveSubstance();
    String getPrice();
    String getProduceCountry();
    String getDosage();
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "YYYY-MM-DD")
    Date getExpiryDate();
    String getContent();
    String getPacking();
    String getDrugInteraction();
    String getContraindication();
    String getDrugStatus();




}
