package com.example.Project_3.sevice.unit.impl;

import com.example.Project_3.constant.message.errorKey.ErrorKey;
import com.example.Project_3.constant.message.messageConst.MessageConst;
import com.example.Project_3.dtos.unit.IGetCommonNameIdCvsRule;
import com.example.Project_3.dtos.unit.UnitCreateDTO;
import com.example.Project_3.dtos.unit.UnitUpdateDTO;
import com.example.Project_3.entities.unit.Unit;
import com.example.Project_3.exceptions.exceptionFactory.ExceptionFactory;
import com.example.Project_3.repositories.unit.UnitRepository;
import com.example.Project_3.sevice.unit.UnitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitRepository unitRepository ;
    @Autowired
    private ExceptionFactory exceptionFactory ;
    @Override
    public void addUnit(UnitCreateDTO unitCreateDTO) {
        Unit unit = new Unit();
        unit.setCreateAt(new Date());
        BeanUtils.copyProperties(unitCreateDTO,unit);
        unit.setUpdateDate(new Date());
        unitRepository.save(unit);
    }

    @Override
    public void updateUnit(Long id, UnitUpdateDTO unitUpdateDTO) {
        Optional<Unit> unit = unitRepository.findById(id);
        if(unit.isPresent()){
            BeanUtils.copyProperties(unitUpdateDTO,unit);
            unit.get().setUpdateDate(new Date());
            unitRepository.save(unit.get());
        }else {
            throw exceptionFactory.resourceNotFoundException(ErrorKey.Unit.NOT_FOUND_ERROR_CODE, MessageConst.RESOURCE_NOT_FOUND,
                    MessageConst.Resources.UNIT,ErrorKey.Unit.ID);
        }
    }

    @Override
    public List<IGetCommonNameIdCvsRule> getListUnit() {
        return unitRepository.getListUnit();
    }


}
