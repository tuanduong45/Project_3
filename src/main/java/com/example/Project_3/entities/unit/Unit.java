package com.example.Project_3.entities.unit;

import com.example.Project_3.entities.drug.Drug;
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
@Table(name = "unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "unit_name")
    private String unitName;
    @Column(name = "conversion_rule")
    private Long conversionRule;
    @Column(name = "create_at")
    private Date createAt;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "unit")
    private Set<Drug> drugSet = new HashSet<>() ;

}
