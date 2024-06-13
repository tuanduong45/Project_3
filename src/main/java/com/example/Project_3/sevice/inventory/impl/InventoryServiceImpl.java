package com.example.Project_3.sevice.inventory.impl;

import com.example.Project_3.dtos.inventory.IGetListDrugBeWarned;
import com.example.Project_3.dtos.inventory.IGetListInventory;
import com.example.Project_3.dtos.inventory.IGetListInventoryDetail;
import com.example.Project_3.repositories.inventory.InventoryRepository;
import com.example.Project_3.sevice.inventory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<IGetListInventory> getListInventory(String drugName, String drugCode) {
        return inventoryRepository.getListInventory(drugName,drugCode);
    }

    @Override
    public List<IGetListInventoryDetail> getListInventoryDetail(Long drugId) {
        return inventoryRepository.getListInventoryDetail(drugId);
    }

    @Override
    public List<IGetListDrugBeWarned> getListDrugBeWarned() {
        return inventoryRepository.getListDrugBeWarned();
    }




}
