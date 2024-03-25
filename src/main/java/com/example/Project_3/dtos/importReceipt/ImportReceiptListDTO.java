package com.example.Project_3.dtos.importReceipt;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
// DTO lấy dữ liệu của mỗi hóa đơn nhập không bao gồm chi tiết hóa đơn
public class ImportReceiptListDTO {
    String importReceiptCode;
    String importPersonName;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    Date importDate;
    String status ;

}
