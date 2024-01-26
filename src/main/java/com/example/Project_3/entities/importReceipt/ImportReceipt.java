package com.example.Project_3.entities.importReceipt;

import com.example.Project_3.entities.drug.Drug;
import com.example.Project_3.entities.supplier.Supplier;
import com.example.Project_3.entities.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "import_receipt")
public class ImportReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "product_name")
    private String productName ;
    @Column(name = "product_company")
    private String productCompany;
    @Column(name = "produce_batch_number")
    private String produceBatchNumber;
    @Column(name = "import_date")
    private Date importDate;
    @Column(name = "total_amount")
    private String totalAmount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id" , insertable = false , updatable = false)
    private User user ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", insertable = false , updatable = false)
    private Supplier supplier;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "importReceipts")
    private Set<Drug> drugs = new HashSet<>() ;

}
