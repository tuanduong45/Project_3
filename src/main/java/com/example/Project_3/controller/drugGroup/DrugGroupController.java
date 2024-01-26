package com.example.Project_3.controller.drugGroup;

import com.example.Project_3.dtos.drugGroup.DrugGroupCreateDTO;
import com.example.Project_3.dtos.drugGroup.DrugGroupUpdateDTO;
import com.example.Project_3.sevice.drugGroup.DrugGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drugGroup")
public class DrugGroupController {
    @Autowired
    private DrugGroupService drugGroupService ;

    @PostMapping("/create")
    public void createDrugGroup(@RequestBody @Validated DrugGroupCreateDTO createDTO){
             drugGroupService.createDrugGroup(createDTO);
    }
    @PutMapping("/update")
    public void updateDrugGroup(@RequestParam(name = "id") Long id ,@RequestBody DrugGroupUpdateDTO groupUpdateDTO){
        drugGroupService.updateDrugGroup(id , groupUpdateDTO);
    }

}
