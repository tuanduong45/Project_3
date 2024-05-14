package com.example.Project_3.sevice.comboBox;

import com.example.Project_3.dtos.common.ICommonIdCodeName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComboBoxService {


    List<ICommonIdCodeName> getComboBoxDepartment();

    List<ICommonIdCodeName> getComboBoxRole();

}
