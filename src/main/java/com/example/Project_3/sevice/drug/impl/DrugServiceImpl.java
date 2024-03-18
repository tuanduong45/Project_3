package com.example.Project_3.sevice.drug.impl;

import com.example.Project_3.constant.message.errorKey.ErrorKey;
import com.example.Project_3.constant.message.messageConst.MessageConst;
import com.example.Project_3.dtos.drug.DrugCreateDTO;
import com.example.Project_3.dtos.drug.DrugListDTO;
import com.example.Project_3.dtos.drug.DrugUpdateDTO;
import com.example.Project_3.dtos.drug.IGetListDrug;
import com.example.Project_3.entities.drug.Drug;
import com.example.Project_3.entities.drugGroup.DrugGroup;
import com.example.Project_3.entities.unit.Unit;
import com.example.Project_3.enums.drugGroupStatus.DrugGroupStatus;
import com.example.Project_3.exceptions.exceptionFactory.ExceptionFactory;
import com.example.Project_3.repositories.drug.DrugRepository;
import com.example.Project_3.repositories.drugGroup.DrugGroupRepository;
import com.example.Project_3.repositories.unit.UnitRepository;
import com.example.Project_3.sevice.drug.DrugService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugRepository drugRepository ;
    @Autowired
    private DrugGroupRepository drugGroupRepository ;
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private ExceptionFactory exceptionFactory;
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

    @Override
    public void updateDrug(Long drugId, DrugUpdateDTO drugUpdateDTO) {
        Optional<Drug> drug = drugRepository.findById(drugId);
        if(drug.isPresent()){
//            Optional<Unit> unit = unitRepository.findById(drugUpdateDTO.getUnitId());
//            unit.ifPresent(value -> drug.get().setUnit(value));
            Optional<DrugGroup> drugGroup = drugGroupRepository.findById(drugUpdateDTO.getDrugGroupId());
            drugGroup.ifPresent(value -> drug.get().setDrugGroup(value) );
            BeanUtils.copyProperties(drugUpdateDTO,drug.get());
            drugGroupRepository.save(drugGroup.get());
            drugRepository.save(drug.get());
//            unitRepository.save(unit.get());
        }else {
            throw exceptionFactory.resourceNotFoundException(ErrorKey.Drug.NOT_FOUND_ERROR_CODE, MessageConst.RESOURCE_NOT_FOUND ,
                    MessageConst.Resources.DRUG,ErrorKey.Drug.ID);
        }
    }

    @Override
    public void deleteDrug(Long id) {
        Optional<Drug> drug = drugRepository.findById(id);
        if(drug.isPresent()){
            drugRepository.delete(drug.get());
        }
        else {
            throw exceptionFactory.resourceNotFoundException(ErrorKey.Drug.NOT_FOUND_ERROR_CODE,MessageConst.RESOURCE_NOT_FOUND,
                    MessageConst.Resources.DRUG , ErrorKey.Drug.ID);
        }
    }

    @Override
    public List<Map<String, List<DrugListDTO>>> getList(Long drugGroupId,String name) {
        List<Map<String,List<DrugListDTO>>> mapList = new ArrayList<>();
        List<IGetListDrug> drugs = drugRepository.getListDrug(drugGroupId,name);
        List<String> drugGroupName = drugGroupRepository.getListDrugGroupName(drugGroupId);
        for(String drugGrName : drugGroupName){
            List<DrugListDTO> drugListDTOS = new ArrayList<>();
            for(IGetListDrug drug : drugs){
                if(drug.getDrugGroupName().equals(drugGrName)){
                    DrugListDTO drugListDTO = new DrugListDTO();
                    BeanUtils.copyProperties(drug,drugListDTO);
                    drugListDTOS.add(drugListDTO);
                }
            }
            Map<String,List<DrugListDTO>> map = new HashMap<>();
            map.put(drugGrName,drugListDTOS);
            mapList.add(map);
        }
        return mapList;
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
