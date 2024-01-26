package com.example.Project_3.entities.drug;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "drug-supplier")
public class DrugSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "drug_id")
    private Long drugId;
    @Column(name = "supplier_id")
    private Long supplierId;
}
