package com.example.Project_3.repositories.drugGroup;

import com.example.Project_3.constant.sql.drugGroup.SQLDrugGroup;
import com.example.Project_3.entities.drugGroup.DrugGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugGroupRepository extends JpaRepository<DrugGroup,Long> {
    boolean existsByDrugGroupCode(String code);

    @Query(nativeQuery = true,value = SQLDrugGroup.GET_DRUG_GROUP_NAME_BY_ID)
    List<String> getListDrugGroupName(@Param("drugGroupId") Long drugGroupId);

    @Query(nativeQuery = true , value = SQLDrugGroup.GET_ID_FROM_DRUG_GROUP_NAME)
    String getIdFromDrugGroupName(@Param("drugGroupName") String name);

    @Query(nativeQuery = true , value = SQLDrugGroup.GET_DRUG_GROUP_DESCRIBE_FROM_NAME)
    String getDrugGroupDescribeFromName(@Param("drugGroupName") String name);
}
