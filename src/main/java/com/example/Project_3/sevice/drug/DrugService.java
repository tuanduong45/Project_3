package com.example.Project_3.sevice.drug;

import com.example.Project_3.dtos.drug.DrugCreateDTO;
import com.example.Project_3.dtos.drug.DrugUpdateDTO;
import org.springframework.stereotype.Service;

@Service
public interface DrugService {
    void createDrug(DrugCreateDTO drugCreateDTO);
    void updateDrug(Long drugId,DrugUpdateDTO drugUpdateDTO);
    void deleteDrug(Long id);
    void getList();

}
