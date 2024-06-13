package com.example.Project_3.controller.inventory;

import com.example.Project_3.dtos.inventory.DrugWarningListDTO;
import com.example.Project_3.dtos.inventory.IGetListInventory;
import com.example.Project_3.dtos.inventory.IGetListInventoryDetail;
import com.example.Project_3.sevice.inventory.DrugWarningService;
import com.example.Project_3.sevice.inventory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService ;

    @Autowired
    private DrugWarningService drugWarningService ;

    @GetMapping("/get-list-inventory")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') " +
            "or hasAuthority('ROLE_HOSPITAL_MANAGER') " +
            "or hasAuthority('ROLE_PHARMACY_STOCKER') " +
            "or hasAuthority('ROLE_MEDICINE_STATISTIC')")
    public List<IGetListInventory> getListInventories (@RequestParam(value = "name" , defaultValue = "",required = false) String drugName,
                                                       @RequestParam(value = "code" , defaultValue = "",required = false) String drugCode) {
        return inventoryService.getListInventory(drugName,drugCode);
    }

    @GetMapping("/get-list-inventory-detail")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') " +
            "or hasAuthority('ROLE_HOSPITAL_MANAGER') " +
            "or hasAuthority('ROLE_PHARMACY_STOCKER') " +
            "or hasAuthority('ROLE_MEDICINE_STATISTIC')")
    public List<IGetListInventoryDetail> getListInventoryDetails (@RequestParam(value = "id",defaultValue = "-1") Long drugId) {
        return inventoryService.getListInventoryDetail(drugId);
    }

    @PostMapping("/add-warning-drug")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') " +
            "or hasAuthority('ROLE_HOSPITAL_MANAGER') " +
            "or hasAuthority('ROLE_PHARMACY_STOCKER') ")
    public void addWarningDrug (@RequestBody DrugWarningListDTO drugWarningListDTO) {
        drugWarningService.addDrugWarning(drugWarningListDTO);
    }



}
