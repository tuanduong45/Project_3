package com.example.Project_3.repositories.inventory;

import com.example.Project_3.entities.inventory.DrugWarning;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugWarningRepository extends JpaRepository<DrugWarning,Long> {

    Boolean existsByProduceBatchNumber(String produceBatchNumber);

    @Query("SELECT dw FROM drug_warning as dw WHERE dw.produce_batch_number = :produceBatchNumber")
    DrugWarning findByProduceBatchNumber(@Param("produceBatchNumber") String produceBatchNumber);

    Boolean existsByDrugId(Long drugId);
}
