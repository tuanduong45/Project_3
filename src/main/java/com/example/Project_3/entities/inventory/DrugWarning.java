package com.example.Project_3.entities.inventory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugWarning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "drug_id")
    private Long drugId;
    @Column(name = "produce_batch_number")
    private String produceBatchNumber;
    @Column(name = "expiry_before_day")
    private Long expiryBeforeDay;


    public DrugWarning(Long drugId, String produceBatchNumber, Long expiryBeforeDay) {
        this.drugId = drugId;
        this.produceBatchNumber = produceBatchNumber;
        this.expiryBeforeDay = expiryBeforeDay;
    }
}
