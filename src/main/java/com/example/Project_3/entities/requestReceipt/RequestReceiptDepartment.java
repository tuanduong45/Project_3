package com.example.Project_3.entities.requestReceipt;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "request_receipt_department")
public class RequestReceiptDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "request_receipt_id")
    private Long requestReceiptId;
    @Column(name = "department_id")
    private Long departmentId;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "unit")
    private String unit;
}
