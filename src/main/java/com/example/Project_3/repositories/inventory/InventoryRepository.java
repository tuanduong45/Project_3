package com.example.Project_3.repositories.inventory;

import com.example.Project_3.constant.sql.inventory.SQLInventory;
import com.example.Project_3.dtos.inventory.IGetListDrugBeWarned;
import com.example.Project_3.dtos.inventory.IGetListInventory;
import com.example.Project_3.dtos.inventory.IGetListInventoryDetail;
import com.example.Project_3.dtos.inventory.IGetListInventoryMinExMaxQuantity;
import com.example.Project_3.entities.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    @Query(nativeQuery = true,value = SQLInventory.GET_LIST_INVENTORY)
    List<IGetListInventory> getListInventory(@Param("name") String drugName, @Param("code") String drugCode);

    @Query(nativeQuery = true,value = SQLInventory.GET_LIST_INVENTORY_DETAIL)
    List<IGetListInventoryDetail> getListInventoryDetail(@Param("id") Long drugId);

    @Query(nativeQuery = true , value = SQLInventory.GET_LIST_DRUG_BE_WARNED)
    List<IGetListDrugBeWarned> getListDrugBeWarned();



    @Query(value = SQLInventory.GET_DRUG_MIN_EXPIRY_MAX_QUANTITY , nativeQuery = true)
    List<IGetListInventoryMinExMaxQuantity> getDrugMinExpiryMaxQuantityByDrugId(@Param("id") Long drugId);

    @Transactional
    @Modifying
    @Query("UPDATE Inventory inventory SET inventory.quantity = :quantity WHERE inventory.produceBatchNumber = :produceBatchNumber")
    Integer updateQuantity(String produceBatchNumber,Long quantity);

}
