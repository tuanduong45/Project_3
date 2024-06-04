package com.example.Project_3.repositories.inventory;

import com.example.Project_3.constant.sql.inventory.SQLInventory;
import com.example.Project_3.dtos.inventory.IGetListInventory;
import com.example.Project_3.dtos.inventory.IGetListInventoryDetail;
import com.example.Project_3.entities.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    @Query(nativeQuery = true,value = SQLInventory.GET_LIST_INVENTORY)
    List<IGetListInventory> getListInventory(@Param("name") String drugName, @Param("code") String drugCode);

    @Query(nativeQuery = true,value = SQLInventory.GET_LIST_INVENTORY_DETAIL)
    List<IGetListInventoryDetail> getListInventoryDetail(@Param("id") Long drugId);
}
