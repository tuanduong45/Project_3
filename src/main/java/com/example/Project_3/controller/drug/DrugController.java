package com.example.Project_3.controller.drug;

import com.example.Project_3.dtos.drug.DrugCreateDTO;
import com.example.Project_3.sevice.drug.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private DrugService drugService ;

    @PostMapping("/create")
    public void createDrug(@RequestBody @Validated DrugCreateDTO drugCreateDTO){
        drugService.createDrug(drugCreateDTO);
    }

}
