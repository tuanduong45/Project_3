package com.example.Project_3.controller.supplier;

import com.example.Project_3.dtos.supplier.SupplierCreateDTO;
import com.example.Project_3.sevice.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
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

    @DeleteMapping("/delete")
    public void deleteSupplier(@RequestParam("id") Long id){
        supplierService.deleteSupplier(id);
    }

    @GetMapping("/getList")
    public List<SupplierCreateDTO> getList(){
        return supplierService.getListSupplier();
    }

}
