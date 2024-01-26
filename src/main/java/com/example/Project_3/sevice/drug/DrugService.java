package com.example.Project_3.sevice.drug;

import com.example.Project_3.dtos.drug.DrugCreateDTO;
import org.springframework.stereotype.Service;

@Service
public interface DrugService {
    void createDrug(DrugCreateDTO drugCreateDTO);

}
