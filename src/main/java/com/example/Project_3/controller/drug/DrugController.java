package com.example.Project_3.controller.drug;

import com.example.Project_3.dtos.drug.DrugCreateDTO;
import com.example.Project_3.dtos.drug.DrugUpdateDTO;
import com.example.Project_3.sevice.drug.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drug")
@PreAuthorize("hasAuthority('ROLE_DEPARTMENT_PHARMACY_MANAGER')")
public class DrugController {
    @Autowired
    private DrugService drugService ;

    @PostMapping("/create")
    public void createDrug(@RequestBody @Validated DrugCreateDTO drugCreateDTO){
        drugService.createDrug(drugCreateDTO);
    }
    @PutMapping("/update")
    public void updateDrug(@RequestParam("id" ) Long id , @RequestBody DrugUpdateDTO drugUpdateDTO){
        drugService.updateDrug(id,drugUpdateDTO);
    }
    @DeleteMapping("/delete")
    public void deleteDrug(@RequestParam("id") Long id){
        drugService.deleteDrug(id);
    }
    @GetMapping("/getList")
    public void getListDrug(){

    }


}
