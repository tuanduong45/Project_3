package com.example.Project_3.repositories.importReceipt;

import com.example.Project_3.entities.importReceipt.ImportReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportReceiptRepository extends JpaRepository<ImportReceipt,Long> {

    Boolean existsByImportReceiptCode(String code);

}
