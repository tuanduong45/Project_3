package com.example.Project_3.controller.unit;

import com.example.Project_3.dtos.unit.UnitCreateDTO;
import com.example.Project_3.dtos.unit.UnitUpdateDTO;
import com.example.Project_3.sevice.unit.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private UnitService unitService ;

    @PostMapping("/create")
    public void createUnit(@RequestBody UnitCreateDTO unitCreateDTO){
        unitService.addUnit(unitCreateDTO);
    }
    @PutMapping("/update")
    public void updateUnit(@RequestParam("id") Long id , UnitUpdateDTO unitUpdateDTO){
        unitService.updateUnit(id, unitUpdateDTO);
    }
}
