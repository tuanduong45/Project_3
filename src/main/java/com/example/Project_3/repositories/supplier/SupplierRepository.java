package com.example.Project_3.repositories.supplier;

import com.example.Project_3.constant.sql.supplier.SQLSupplier;
import com.example.Project_3.dtos.supplier.IGetListSupplier;
import com.example.Project_3.entities.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    @Query(nativeQuery = true , value = SQLSupplier.GET_LIST_SUPPLIER)
    List<IGetListSupplier> getListSupplier(@Param("name") String name , @Param("taxCode") String taxCode);


    @Transactional
    @Modifying
    @Query("UPDATE Supplier supplier SET supplier.status = 2 WHERE supplier.id = :supplierId")
    void switchSupplierStatus(@Param("supplierId") Long id);
}
