package com.example.Project_3.sevice.comboBox.impl;

import com.example.Project_3.dtos.common.ICommonIdCodeName;
import com.example.Project_3.repositories.comboBox.ComboBoxRepository;
import com.example.Project_3.sevice.comboBox.ComboBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComboBoxServiceImpl implements ComboBoxService {

    @Autowired
    private ComboBoxRepository comboBoxRepository ;
    @Override
    public List<ICommonIdCodeName> getComboBoxDepartment() {
        return comboBoxRepository.getComboBoxDepartment();
    }

    @Override
    public List<ICommonIdCodeName> getComboBoxRole() {
        return comboBoxRepository.getComboBoxRole();
    }
}
