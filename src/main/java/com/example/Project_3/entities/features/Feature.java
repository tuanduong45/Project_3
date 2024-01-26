package com.example.Project_3.entities.features;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "features")
//@TypeDefs(
//        @TypeDef(name = "string-array", typeClass = StringArrayType.class)
//)
public class Feature {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    @NotNull
    private String code;

    @Column(name = "parent_code", nullable = false)
    private String parentCode;

    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "lst_usable_role", columnDefinition = "text[]")
    String[] lstUsableRole;
}
