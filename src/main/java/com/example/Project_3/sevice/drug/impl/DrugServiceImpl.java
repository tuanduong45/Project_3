package com.example.Project_3.sevice.drug.impl;

import com.example.Project_3.dtos.drug.DrugCreateDTO;
import com.example.Project_3.entities.drug.Drug;
import com.example.Project_3.entities.drugGroup.DrugGroup;
import com.example.Project_3.enums.drugGroupStatus.DrugGroupStatus;
import com.example.Project_3.repositories.drug.DrugRepository;
import com.example.Project_3.repositories.drugGroup.DrugGroupRepository;
import com.example.Project_3.sevice.drug.DrugService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugRepository drugRepository ;
    @Autowired
    private DrugGroupRepository drugGroupRepository ;
    @Override
    public void createDrug(DrugCreateDTO drugCreateDTO) {
        Drug drug = new Drug();
        BeanUtils.copyProperties(drugCreateDTO,drug);
        drug.setCode(generateDrugCode());
        drug.setRegistrationNumber(generateDrugRegistrationNumber());
        Optional<DrugGroup> drugGroup = drugGroupRepository.findById(drugCreateDTO.getDrugGroupId());
        drug.setDrugGroup(drugGroup.get());
        drugGroup.get().setStatus(DrugGroupStatus.ACTIVE.getValue());
        drugRepository.save(drug);
        drugGroupRepository.save(drugGroup.get());
    }

    // tạo mã code cho thuốc
    public  String generateDrugCode(){
        String baseCode = "DHG000";
        Random random = new Random() ;
        String generateCode = baseCode + (random.nextInt(10000) + 40000);
        while (drugRepository.existsByCode(generateCode)){
            generateCode = baseCode + (random.nextInt(10000) + 40000);
        }
        return generateCode;
    }
    // tạo mã đăng kí cho thuốc
    public String generateDrugRegistrationNumber(){
        String baseCode = "VD-";
        Random random = new Random();
        String generateRegisNumber = baseCode + (random.nextInt(1000)+19000) + "-" + (random.nextInt(20));
        while (drugRepository.existsByRegistrationNumber(generateRegisNumber)){
            generateRegisNumber = baseCode + (random.nextInt(1000)+19000) + "-" + (random.nextInt(20));
        }
        return generateRegisNumber;
    }
}
