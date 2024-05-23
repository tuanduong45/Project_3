package com.example.Project_3.dtos.drug;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugCreateDTO {
    @NotNull
    @NotBlank
    private String name ;
    @NotNull
    @NotBlank
    private String activeSubstance;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd")
        private Date expiryDate;
    @NotNull
    @NotBlank
    private String dosageForm;
    private String produceCountry;
    @NotNull
    private String content;
    @NotNull
    @NotBlank
    private String packing ;
    @NotNull
    @NotBlank
    private String drugInteraction;
    @NotNull
    @NotBlank
    private String contraindication;
    @NotNull
    @NotBlank
    private String dosage ;
    @NotNull
    @NotBlank
    private String usage;
    private String price;
    @NotNull
    private Long drugGroupId;

    private Set<Long> lstUnitId;


}
