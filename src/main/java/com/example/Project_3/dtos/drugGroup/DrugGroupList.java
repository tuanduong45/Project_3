package com.example.Project_3.dtos.drugGroup;

import com.example.Project_3.dtos.drug.IGetListDrug;
import lombok.Data;

import java.util.List;


public interface DrugGroupList {
    String getName();
    List<IGetListDrug> getDrugs();
}
