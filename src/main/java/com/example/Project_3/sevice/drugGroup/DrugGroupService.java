package com.example.Project_3.sevice.drugGroup;

import com.example.Project_3.dtos.drugGroup.DrugGroupCreateDTO;
import com.example.Project_3.dtos.drugGroup.DrugGroupUpdateDTO;
import org.springframework.stereotype.Service;

@Service
public interface DrugGroupService {
    void createDrugGroup(DrugGroupCreateDTO groupCreateDTO);
    void updateDrugGroup(Long id ,DrugGroupUpdateDTO groupUpdateDTO);
    void deleteDrugGroup(Long id );

}
