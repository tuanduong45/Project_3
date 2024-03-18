package com.example.Project_3.entities.drugGroup;

import com.example.Project_3.entities.drug.Drug;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "drug_group")
public class DrugGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "drug_group_name")
    private String drugGroupName;
    @Column(name = "drug_group_code")
    private String drugGroupCode;
    @Column(name = "drug_group_describe")
    private String drugGroupDescribe;
    @Column (name = "status" , insertable = true , updatable = true )
    private Integer status;
    @OneToMany(fetch = FetchType.EAGER ,mappedBy = "drugGroup" )
    private Set<Drug> drugs ;
}
