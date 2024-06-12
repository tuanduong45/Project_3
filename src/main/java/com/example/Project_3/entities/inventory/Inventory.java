package com.example.Project_3.entities.inventory;

import com.example.Project_3.entities.drug.Drug;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
@Entity
@ToString
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "produce_batch_number",unique = true)
    private String produceBatchNumber;
    @Column(name = "expiry_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date expiryDate;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "price")
    private Long price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drug_id")
    private Drug drug ;

    public Inventory(String produceBatchNumber, Date expiryDate, Long quantity, Long price, Drug drug) {
        this.produceBatchNumber = produceBatchNumber;
        this.expiryDate = expiryDate;
        this.quantity = quantity ;
        this.price = price  ;
        this.drug = drug ;
    }
}
