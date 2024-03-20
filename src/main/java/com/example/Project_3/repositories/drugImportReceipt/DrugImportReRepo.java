package com.example.Project_3.repositories.drugImportReceipt;

import com.example.Project_3.entities.drug.DrugImportReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugImportReRepo extends JpaRepository<DrugImportReceipt,Long> {

}
