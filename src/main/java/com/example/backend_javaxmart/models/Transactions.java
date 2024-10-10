package com.example.backend_javaxmart.models;

import java.io.Serializable;
import java.math.BigDecimal;

import com.example.backend_javaxmart.models.ID.TransactionId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Transactions implements Serializable {
    @EmbeddedId
    private TransactionId id;

    @ManyToOne
    @JoinColumn(name = "qrcode", insertable = false, updatable = false)
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "rfid", insertable = false, updatable = false)
    private Product product;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "total_product")
    private Integer totalProduct;
}