package com.example.Project_3.controller.comboBox;

import com.example.Project_3.dtos.common.ICommonIdCodeName;
import com.example.Project_3.sevice.comboBox.ComboBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/combo-box")
public class ComboBoxController {
    @Autowired
    private ComboBoxService comboBoxService ;

    @GetMapping("/get-lst-department-name-code")
    public List<ICommonIdCodeName> getComboBoxDepartment(){
        return comboBoxService.getComboBoxDepartment();
    }

    @GetMapping("/get-lst-role-name-code")
    public List<ICommonIdCodeName> getComboBoxRole(){
        return comboBoxService.getComboBoxRole();
    }
}
