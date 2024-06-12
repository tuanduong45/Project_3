package com.example.Project_3.sevice.inventory;

import com.example.Project_3.dtos.inventory.IGetListDrugBeWarned;
import com.example.Project_3.dtos.inventory.IGetListInventory;
import com.example.Project_3.dtos.inventory.IGetListInventoryDetail;
import com.example.Project_3.dtos.inventory.IGetListInventoryMinExMaxQuantity;
import com.example.Project_3.entities.inventory.Inventory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {


    List<IGetListInventory> getListInventory(String drugName, String drugCode);

    List<IGetListInventoryDetail> getListInventoryDetail(Long drugId);

    List<IGetListDrugBeWarned> getListDrugBeWarned();






}
