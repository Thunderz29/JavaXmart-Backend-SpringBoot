package com.example.backend_javaxmart.services;

import com.example.backend_javaxmart.dto.DataDTO;
import com.example.backend_javaxmart.dto.TransactionDTO;

public interface TransactionService {
    DataDTO<TransactionDTO> getTransactionHistoryByQRCode(String qrCode);

    DataDTO<TransactionDTO> getAllTransactions();
}