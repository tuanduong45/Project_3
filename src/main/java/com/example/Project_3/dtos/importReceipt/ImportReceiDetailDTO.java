package com.example.Project_3.dtos.importReceipt;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImportReceiDetailDTO {
    @NotNull
    Long drugId;
    @NotNull
    String produceBatchNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")
    Date expiryDate;
    @NotNull
    Long quantity;
    Long unitId ;
    Long price;
    Long supplierId;

}
