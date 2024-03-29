package com.example.Project_3.entities.requestReceipt;

import com.example.Project_3.entities.department.Department;
import com.example.Project_3.entities.drug.Drug;
import com.example.Project_3.entities.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "request_receipt")
public class RequestReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    @NotNull
    private Long id ;
    @Column(name = "request_receipt_code",unique = true )
    private String requestReceiptCode;
    @Column(name = "request_date")
    private Date requestDate;
    @Column(name = "request_status")
    private Integer requestStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id" )
    private User user ;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "requestReceipts")
    private Set<Drug> drugs = new HashSet<>() ;

}
