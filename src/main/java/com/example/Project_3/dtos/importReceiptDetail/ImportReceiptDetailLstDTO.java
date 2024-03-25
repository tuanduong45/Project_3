package com.example.Project_3.dtos.importReceiptDetail;

import com.fasterxml.jackson.annotation.JsonFormat;
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
// DTO lấy ra dữ liệu của mỗi chi tiết hóa đơn
public class ImportReceiptDetailLstDTO {
    String drugName;
    String supplierName;
    String produceBatchNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    Date expiryDate;
    Long quantity;
    Long price;
    Long totalAmount;

}
