package com.example.Project_3.entities.drug;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "request_receipt_drug")
public class DrugRequestReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "drug_id")
    private Long drugId;
    @Column(name = "request_receipt_id")
    private Long requestReceiptId;
    @Column(name = "quantity")
    private Long quantity ;
    @Column(name = "unit")
    private Long unitID ;

    public DrugRequestReceipt(Long drugID, Long requestReceiptID, Long quantity, Long unitID) {
        this.drugId = drugID;
        this.quantity = quantity ;
        this.unitID = unitID;
        this.requestReceiptId =requestReceiptID;
    }
}
