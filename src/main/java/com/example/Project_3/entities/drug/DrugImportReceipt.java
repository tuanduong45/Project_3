package com.example.Project_3.entities.drug;

import com.example.Project_3.entities.supplier.Supplier;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drug_import_receipt")
public class DrugImportReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "drug_id")
    private Long drugId;
    @Column(name = "import_receipt_id")
    private Long importReceiptId;
    // số lượng
    @Column(name = "quantity")
    private Long quantity;
    // đơn vị tính
    @Column(name = "unit_id")
    private Long unitId;
    @Column(name = "price")
    private Long price;
    // ngày hết hạn
    @Column(name = "expiry_date")
    private Date expiryDate;
    // số lô sản xuất
    @Column(name = "produce_batch_number")
    private String produceBatchNumber;
    // tổng tiền
    @Column(name = "total_amount")
    private Long totalAmount;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;



    public DrugImportReceipt(Long importReceiptID, Long drugId, Long quantity, Long unitId,
                             Long price, Date expiryDate, String produceBatchNumber, Supplier supplier) {
        this.importReceiptId = importReceiptID ;
        this.drugId = drugId ;
        this.quantity = quantity;
        this.unitId = unitId;
        this.price = price;
        this.expiryDate = expiryDate;
        this.produceBatchNumber = produceBatchNumber;
        this.supplier =supplier;

    }
}


    
