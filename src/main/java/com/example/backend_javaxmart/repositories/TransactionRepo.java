package com.example.backend_javaxmart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend_javaxmart.models.Transactions;

@Repository
public interface TransactionRepo extends JpaRepository<Transactions, String> {
    List<Transactions> findByCustomerQrCode(String qrCode);
}