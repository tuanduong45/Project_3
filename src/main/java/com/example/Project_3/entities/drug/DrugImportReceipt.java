package com.example.Project_3.entities.drug;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drug_import_receipt")
public class DrugImportReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "drug_id" )
    private Long drugId ;
    @Column(name = "import_receipt_id")
    private Long importReceiptId;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "unit")
    private String unit;
    @Column(name = "price")
    private String price;
    @Column(name = "expiry_date")
    private Date expiryDate;
}
