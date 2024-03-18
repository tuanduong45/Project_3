package com.example.Project_3.entities.unit;

import com.example.Project_3.entities.drug.Drug;
import io.swagger.models.auth.In;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;


import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "unit_name")
    private String unitName;
    // quy tắc chuyển đổi
    @Column(name = "conversion_rule" )
    private Long conversionRule;
    // đặc điểm đơn vị tính
    @Column(name = "unit_characteristic")
    private String unitCharacteristic;
    // đơn vị đo
    @Column(name = "unit_measure" )
    private String unitMeasure ;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "last_update_date")
    private Date updateDate;
    @OneToMany(fetch = FetchType.LAZY  ,mappedBy = "unit")
    private Set<Drug> drugSet = new HashSet<>();

}
