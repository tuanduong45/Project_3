package com.example.Project_3.sevice.drugGroup;

import com.example.Project_3.dtos.drugGroup.DrugGroupCreateDTO;
import com.example.Project_3.dtos.drugGroup.DrugGroupList;
import com.example.Project_3.dtos.drugGroup.DrugGroupUpdateDTO;
import com.example.Project_3.entities.drugGroup.DrugGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DrugGroupService {
    void createDrugGroup(DrugGroupCreateDTO groupCreateDTO);
    void updateDrugGroup(Long id ,DrugGroupUpdateDTO groupUpdateDTO);
    void deleteDrugGroup(Long id );

    List<DrugGroup> getLstDrugGroup();

    // Lấy Id của drug Group từ name
    Long getIdFromDrugGroupName(String name);

    // lấy DrugGroupDescribe từ name

    String getDrugGroupDescribe(String name);



}
