package com.example.Project_3.sevice.drug;

import com.example.Project_3.dtos.drug.DrugCreateDTO;
import com.example.Project_3.dtos.drug.DrugListDTO;
import com.example.Project_3.dtos.drug.DrugUpdateDTO;
import com.example.Project_3.dtos.drug.IGetListDrug;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DrugService {
    void createDrug(DrugCreateDTO drugCreateDTO);
    void updateDrug(Long drugId,DrugUpdateDTO drugUpdateDTO);
    void deleteDrug(Long id);
    List<Map<String,List<DrugListDTO>>> getList(Long drugGroupId, String name);

}
