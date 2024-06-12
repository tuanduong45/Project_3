package com.example.Project_3.sevice.inventory;

import com.example.Project_3.dtos.inventory.IGetListDrugBeWarned;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

    @Component
    public class ExpirationScheduler {

        @Autowired
        private InventoryService inventoryService ;

        @Scheduled(cron = "0 0 0 * * ?")
        public void scheduleDrugWarning() {
             List<IGetListDrugBeWarned> list = inventoryService.getListDrugBeWarned();
             if(list.size() > 0 ) {
                 System.out.println("Danh sách thuốc bị cảnh báo là : " + list.stream().toList());
             } else  {
                 System.out.println("Không có thuốc nào bị cảnh báo");
             }
        }
    }
