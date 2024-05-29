package com.example.Project_3.sevice.drug;

import com.example.Project_3.dtos.common.ICommonIdCodeName;
import com.example.Project_3.dtos.drug.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DrugService {
    void createDrug(DrugCreateDTO drugCreateDTO);
    void updateDrug(Long drugId,DrugUpdateDTO drugUpdateDTO);
    void switchStatusDrug(Long id);
    List<Map<String,List<DrugListDTO>>> getList(Long drugGroupId, String name);

    List<ICommonIdCodeName> getListDrugIdCodeName();



}
