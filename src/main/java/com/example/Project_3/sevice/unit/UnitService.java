package com.example.Project_3.sevice.unit;

import com.example.Project_3.dtos.unit.IGetCommonNameIdCvsRule;
import com.example.Project_3.dtos.unit.UnitCreateDTO;
import com.example.Project_3.dtos.unit.UnitUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UnitService {
    void addUnit(UnitCreateDTO unitCreateDTO);
    void updateUnit(Long id ,UnitUpdateDTO unitUpdateDTO);
    // lấy list unit bao gồm id , name , conversion_rule
    List<IGetCommonNameIdCvsRule> getListUnit();
}
