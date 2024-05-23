package com.example.Project_3.repositories.unit;

import com.example.Project_3.constant.sql.unit.SQLUnit;
import com.example.Project_3.dtos.unit.IGetCommonNameIdCvsRule;
import com.example.Project_3.entities.unit.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit,Long> {

    @Query(nativeQuery = true , value = SQLUnit.GET_LIST_UNIT)
    List<IGetCommonNameIdCvsRule> getListUnit();

}
