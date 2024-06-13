package com.example.Project_3.sevice.inventory;

import com.example.Project_3.dtos.inventory.IGetListDrugBeWarned;
import com.example.Project_3.dtos.inventory.IGetListInventory;
import com.example.Project_3.dtos.inventory.IGetListInventoryDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {


    List<IGetListInventory> getListInventory(String drugName, String drugCode);

    List<IGetListInventoryDetail> getListInventoryDetail(Long drugId);

    List<IGetListDrugBeWarned> getListDrugBeWarned();






}
