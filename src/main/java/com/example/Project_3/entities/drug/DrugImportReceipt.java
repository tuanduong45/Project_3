package com.example.Project_3.entities.drug;

import com.example.Project_3.entities.supplier.Supplier;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drug_import_receipt")
// chi tiết phiếu nhập kho thuốc
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
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")
    private Date expiryDate;
    // số lô sản xuất
    @Column(name = "produce_batch_number",unique = true)
    private String produceBatchNumber;
    // tổng tiền
    @Column(name = "total_amount")
    private Long totalAmount;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;



    public DrugImportReceipt(Long importReceiptID, Long drugId, Long quantity, Long unitId,
                             Long price, Date expiryDate, String produceBatchNumber, Supplier supplier,Long totalAmount) {
        this.importReceiptId = importReceiptID ;
        this.drugId = drugId ;
        this.quantity = quantity;
        this.unitId = unitId;
        this.price = price;
        this.expiryDate = expiryDate;
        this.produceBatchNumber = produceBatchNumber;
        this.supplier =supplier;
        this.totalAmount = totalAmount;

    }
}


    
