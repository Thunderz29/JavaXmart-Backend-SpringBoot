package com.example.backend_javaxmart.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.example.backend_javaxmart.models.Customers;
import com.example.backend_javaxmart.models.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransactionDTO {
    Customers customer;
    Product product;
    BigDecimal price;
    Integer totalProduct;
    Date date;
}
