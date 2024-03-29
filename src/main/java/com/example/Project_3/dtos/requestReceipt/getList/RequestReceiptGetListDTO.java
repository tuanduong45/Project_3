package com.example.Project_3.dtos.requestReceipt.getList;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)
@Builder
public class RequestReceiptGetListDTO {
    String requestReceiptCode;
    String creatorName;
    String departmentName;
    Date requestDate;
    String requestStatus;
}
