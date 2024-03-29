package com.example.Project_3.repositories.drugRequestReceipt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRequestReceiptRepository extends JpaRepository<com.example.Project_3.entities.drug.DrugRequestReceipt,Long> {

}
