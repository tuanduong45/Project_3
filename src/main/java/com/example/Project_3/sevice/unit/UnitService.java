package com.example.Project_3.sevice.unit;

import com.example.Project_3.dtos.unit.UnitCreateDTO;
import com.example.Project_3.dtos.unit.UnitUpdateDTO;
import org.springframework.stereotype.Service;

@Service
public interface UnitService {
    void addUnit(UnitCreateDTO unitCreateDTO);
    void updateUnit(Long id ,UnitUpdateDTO unitUpdateDTO);
}
