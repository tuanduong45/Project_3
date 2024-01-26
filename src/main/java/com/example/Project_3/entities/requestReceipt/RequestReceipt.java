package com.example.Project_3.entities.requestReceipt;

import com.example.Project_3.entities.department.Department;
import com.example.Project_3.entities.drug.Drug;
import com.example.Project_3.entities.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "request_receipt")
public class RequestReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private Long id ;
    @Column(name = "drug_name")
    private String drugName;
    @Column(name = "request_date")
    private Date requestDate;
    @Column(name = "request_status")
    private String requestStatus;
    @Column(name = "creator_name")
    private String creatorName ;
    @Column(name = "request_department_name")
    private String requestDepartmentName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id" , insertable = false , updatable = false)
    private User user ;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "request_receipt_department" ,
    joinColumns = {
            @JoinColumn(name = "request_receipt_id" , referencedColumnName = "id")
    } ,
    inverseJoinColumns = {
            @JoinColumn(name = "department_id" , referencedColumnName = "id")
    })
    private Set<Department> departments = new HashSet<>() ;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "requestReceipts")
    private Set<Drug> drugs = new HashSet<>() ;

}
