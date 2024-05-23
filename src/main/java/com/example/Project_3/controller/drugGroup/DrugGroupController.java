package com.example.Project_3.controller.drugGroup;

import com.example.Project_3.dtos.drugGroup.DrugGroupCreateDTO;
import com.example.Project_3.dtos.drugGroup.DrugGroupUpdateDTO;
import com.example.Project_3.entities.drugGroup.DrugGroup;
import com.example.Project_3.sevice.drugGroup.DrugGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drug-group")
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

    @GetMapping("/getList")
    public List<DrugGroup> getLstDrugGroup(){
     return drugGroupService.getLstDrugGroup();
    }

    @GetMapping("/get-id")
    public Long getIdFromDrugGroupName (@RequestParam(name = "name") String name) {
        return drugGroupService.getIdFromDrugGroupName(name);
    }

    @GetMapping("/get-drug-group-describe")
    public String getDrugGroupDescribeFromName(@RequestParam(name = "name") String name) {
        return drugGroupService.getDrugGroupDescribe(name);
    }

    @DeleteMapping("/delete")
    public void deleteDrugGroup(@RequestParam("id") Long id){
        drugGroupService.deleteDrugGroup(id);
    }

}
