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
    // mã code đơn nhập
    @Column(name = "import_receipt_code")
    private String importReceiptCode ;
    // tên người nhập
    @Column(name = "import_person_name")
    private String importPerName;
    @Column(name = "import_date")
    // ngày nhập
    private Date importDate;
    // trạng thái
    @Column(name = "status")
    private String status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id" , insertable = false , updatable = false)
    private User user ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", insertable = false , updatable = false)
    private Supplier supplier;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "importReceipts")
    private Set<Drug> drugs = new HashSet<>() ;

}
