package com.example.Project_3.controller.supplier;

import com.example.Project_3.dtos.common.ICommonIdTaxCodeName;
import com.example.Project_3.dtos.supplier.IGetListSupplier;
import com.example.Project_3.dtos.supplier.SupplierCreateDTO;
import com.example.Project_3.entities.supplier.Supplier;
import com.example.Project_3.sevice.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@PreAuthorize("hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') or hasAuthority('ROLE_HOSPITAL_MANAGER')")
public class SupplierController {
    @Autowired
    private SupplierService supplierService ;

    @PostMapping("/create")
    public void createSupplier(@RequestBody SupplierCreateDTO supplierCreateDTO){
        supplierService.addSupplier(supplierCreateDTO);
    }

    @PutMapping("/update")
    public void updateSupplier(@RequestParam("id") Long id,@RequestBody SupplierCreateDTO supplierCreateDTO){
        supplierService.updateSupplier(id,supplierCreateDTO);
    }

    @PutMapping("/delete")
    public void switchSupplierStatus(@RequestParam("supplierId") Long id){
        supplierService.switchSupplierStatus(id);
    }

    @GetMapping("/get-list")
    public List<IGetListSupplier> getList(@RequestParam(value = "name" , required = false ,defaultValue = "") String name ,
                                          @RequestParam(value = "taxCode", required = false , defaultValue = "") String taxCode){
        return supplierService.getListSupplier(name,taxCode);
    }

    @GetMapping("/get-list-id-taxCode-name")
    public List<ICommonIdTaxCodeName> getListSupplierIdTaxCodeName() {
        return supplierService.getListSupplierIdTaxCodeName();
    }

}
