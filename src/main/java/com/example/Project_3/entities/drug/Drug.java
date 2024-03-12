package com.example.Project_3.entities.drug;

import com.example.Project_3.entities.drugGroup.DrugGroup;
import com.example.Project_3.entities.importReceipt.ImportReceipt;
import com.example.Project_3.entities.requestReceipt.RequestReceipt;
import com.example.Project_3.entities.supplier.Supplier;
import com.example.Project_3.entities.unit.Unit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false , unique = true)
    private Long id ;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    // hoạt chất
    @Column(name = "active_substance")
    private String activeSubstance;
    @Column(name = "expiry_date")
    private Date expiryDate ;
    // dạng bào chế
    @Column(name = "dosage_form")
    private String dosageForm;
    @Column(name = "produce_country")
    private String produceCountry;
    // hàm lượng
    @Column(name = "content")
    private String content;
    // cách đóng gói
    @Column(name = "packing")
    private String packing;
    // số đăng kí
    @Column(name = "registration_number")
    private String registrationNumber;
    // tương tác thuốc
    @Column(name = "drug_interaction",nullable = true)
    private String drugInteraction;
    // chống chỉ định
    @Column(name = "contraindication",nullable = true)
    private String contraindication;
    // cách dùng
    @Column(name = "usage")
    private String usage;
    // liều dùng
    @Column(name = "dosage")
    private String dosage;
    @Column(name = "price")
    private String price ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_id" , insertable = true , updatable = true)
    private Unit unit ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drug_group_id" , insertable = true,updatable = true)
    private DrugGroup drugGroup ;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "drug-supplier",
    joinColumns = {
            @JoinColumn(name = "drug_id",referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "supplier_id",referencedColumnName = "id")
    })

    private Set<Supplier> supplierSet = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "request_receipt_drug" ,
    joinColumns = {
            @JoinColumn(name = "drug_id" , referencedColumnName = "id" )
    },
            inverseJoinColumns = {
            @JoinColumn(name = "request_receipt_id" , referencedColumnName = "id")
            })
    private Set<RequestReceipt> requestReceipts = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "drug_import_receipt" ,
    joinColumns = {
            @JoinColumn (name = "drug_id" , referencedColumnName = "id")
    } ,
    inverseJoinColumns = {
            @JoinColumn(name = "import_receipt_id" , referencedColumnName = "id")
    })
    private Set<ImportReceipt> importReceipts = new HashSet<>() ;



    }

