package com.example.Project_3.sevice.drugGroup.impl;

import com.example.Project_3.dtos.drugGroup.DrugGroupCreateDTO;
import com.example.Project_3.dtos.drugGroup.DrugGroupUpdateDTO;
import com.example.Project_3.entities.drugGroup.DrugGroup;
import com.example.Project_3.enums.drugGroupStatus.DrugGroupStatus;
import com.example.Project_3.repositories.drugGroup.DrugGroupRepository;
import com.example.Project_3.sevice.drugGroup.DrugGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrugGroupServiceImpl implements DrugGroupService {
    @Autowired
    private DrugGroupRepository drugGroupRepository ;
    @Override
    public void createDrugGroup(DrugGroupCreateDTO groupCreateDTO) {
        DrugGroup drugGroup = new DrugGroup() ;
        BeanUtils.copyProperties(groupCreateDTO,drugGroup);
        drugGroup.setStatus(DrugGroupStatus.UNACTIVE.getValue());
        drugGroupRepository.save(drugGroup);
    }

    @Override
    public void updateDrugGroup(Long id, DrugGroupUpdateDTO groupUpdateDTO) {
        Optional<DrugGroup> drugGroup = drugGroupRepository.findById(id);
        BeanUtils.copyProperties(groupUpdateDTO,drugGroup.get());
    }

    @Override
    public void deleteDrugGroup(Long id) {
        Optional<DrugGroup> drugGroup = drugGroupRepository.findById(id);
        drugGroupRepository.delete(drugGroup.get());
    }



}

