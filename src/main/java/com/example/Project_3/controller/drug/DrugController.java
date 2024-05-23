package com.example.Project_3.controller.drug;

import com.example.Project_3.dtos.drug.DrugCreateDTO;
import com.example.Project_3.dtos.drug.DrugListDTO;
import com.example.Project_3.dtos.drug.DrugUpdateDTO;
import com.example.Project_3.sevice.drug.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/drug")
public class DrugController {
    @Autowired
    private DrugService drugService ;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER')")
    public void createDrug(@RequestBody @Validated DrugCreateDTO drugCreateDTO){
        drugService.createDrug(drugCreateDTO);
    }
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER')")
    public void updateDrug(@RequestParam("id" ) Long id , @RequestBody DrugUpdateDTO drugUpdateDTO){
        drugService.updateDrug(id,drugUpdateDTO);
    }
    @PutMapping("/switch-status")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER')")
    public void switchDrugStatus(@RequestParam("drugId") Long id){
        drugService.switchStatusDrug(id);
    }
    @GetMapping("/get-list")
    @PreAuthorize("hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER') or hasAuthority('ROLE_HOSPITAL_MANAGER')")
    public List<Map<String,List<DrugListDTO>>> getListDrug(@RequestParam(value = "drugGrId" , required = false , defaultValue = "-1") Long id
            , @RequestParam(value = "name" , required = false , defaultValue = "") String name){
     return   drugService.getList(id,name);
    }


}
