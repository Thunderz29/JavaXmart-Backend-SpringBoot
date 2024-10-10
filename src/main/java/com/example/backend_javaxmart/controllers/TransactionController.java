package com.example.backend_javaxmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_javaxmart.dto.DataDTO;
import com.example.backend_javaxmart.dto.TransactionDTO;
import com.example.backend_javaxmart.services.TransactionService;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "*")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/history/{qrcode}")
    public ResponseEntity<DataDTO<TransactionDTO>> getTransactionHistoryByQRCode(@PathVariable String qrcode) {
        return ResponseEntity.ok(transactionService.getTransactionHistoryByQRCode(qrcode));
    }

    @GetMapping("/history")
    public ResponseEntity<DataDTO<TransactionDTO>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
}