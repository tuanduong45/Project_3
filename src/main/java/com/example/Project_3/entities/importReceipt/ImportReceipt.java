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
    // tên người tạo đơn
    @Column(name = "import_person_name")
    private String importPersonName;
    @Column(name = "import_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
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
