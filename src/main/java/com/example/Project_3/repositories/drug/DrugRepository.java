package com.example.Project_3.repositories.drug;

import com.example.Project_3.constant.sql.drug.SQLDrug;
import com.example.Project_3.entities.drug.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drug,Long> {
    Boolean existsByCode(String code);
    Boolean existsByRegistrationNumber(String regisNumber);
}
