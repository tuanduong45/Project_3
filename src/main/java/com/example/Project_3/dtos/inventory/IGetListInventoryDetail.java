package com.example.Project_3.dtos.inventory;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface IGetListInventoryDetail {
    String getProduceBatchNumber();
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",timezone = "Asia/Ho_Chi_Minh")
    Date getExpiryDate();
    Long getQuantity();
    Long getPrice();

}
