package com.example.Project_3.entities.importReceipt;

import com.example.Project_3.entities.drug.Drug;
import com.example.Project_3.entities.supplier.Supplier;
import com.example.Project_3.entities.users.User;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Column(name = "import_date")
    // ngày nhập
    private Date importDate;
    // trạng thái
    @Column(name = "status")
    private Integer status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id" , insertable = true , updatable = false)
    private User user ;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "importReceipts")
    private Set<Drug> drugs = new HashSet<>() ;

}
