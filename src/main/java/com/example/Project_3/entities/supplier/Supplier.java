package com.example.Project_3.entities.supplier;

import com.example.Project_3.entities.drug.Drug;
import com.example.Project_3.entities.drug.DrugImportReceipt;
import com.example.Project_3.entities.importReceipt.ImportReceipt;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true ,  nullable = false)
    private Long id;
    @Column(name = "name")
    private String name ;
    @Column(name = "address")
    private String address ;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "tax_code")
    private String taxCode;
    @Column(name = "representative_name")
    private String representativeName;
    @Column(name = "status")
    private Integer status;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "supplierSet")
    private Set<Drug> drugSet = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "supplier")
    private Set<DrugImportReceipt> drugImportReceipts = new HashSet<>() ;
}
