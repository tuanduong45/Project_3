package com.example.Project_3.dtos.importReceipt;

import com.example.Project_3.dtos.importReceiptDetail.ImportReceiDetailDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
// DTO hóa đơn nhập khi thêm hóa đơn
public class ImportReceiptDTO {
    Set<ImportReceiDetailDTO> importReceiDetailDTOS ;

}
