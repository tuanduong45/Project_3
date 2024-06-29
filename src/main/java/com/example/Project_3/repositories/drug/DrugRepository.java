package com.example.Project_3.repositories.drug;

import com.example.Project_3.constant.sql.drug.SQLDrug;
import com.example.Project_3.dtos.common.ICommonIdCodeName;
import com.example.Project_3.dtos.drug.IGetListDrug;
import com.example.Project_3.entities.drug.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DrugRepository extends JpaRepository<Drug,Long> {
    Boolean existsByCode(String code);
    Boolean existsByRegistrationNumber(String regisNumber);
    @Query(nativeQuery = true,value = SQLDrug.GET_LIST_DRUG)
    List<IGetListDrug> getListDrug(@Param("drugGroupId") Long id , @Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Drug drug SET drug.status = 1 WHERE drug.id = :drugId")
    void switchDrugStatus(@Param("drugId") Long id);

    @Query(nativeQuery = true,value = SQLDrug.GET_LIST_DRUG_ID_CODE_NAME )
    List<ICommonIdCodeName> getListDrugIdCodeName();


}
