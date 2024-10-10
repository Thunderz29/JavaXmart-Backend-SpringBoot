package com.example.backend_javaxmart.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_javaxmart.dto.DataDTO;
import com.example.backend_javaxmart.dto.TransactionDTO;
import com.example.backend_javaxmart.models.Transactions;
import com.example.backend_javaxmart.repositories.TransactionRepo;
import com.example.backend_javaxmart.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
        @Autowired
        TransactionRepo transactionRepository;

        @Override
        public DataDTO<TransactionDTO> getTransactionHistoryByQRCode(String qrCode) {
                List<Transactions> transactionList = transactionRepository.findByCustomerQrCode(qrCode);
                List<TransactionDTO> dataList = transactionList.stream()
                                .map(transaction -> TransactionDTO.builder()
                                                .customer(transaction.getCustomer())
                                                .product(transaction.getProduct())
                                                .price(transaction.getPrice())
                                                .totalProduct(transaction.getTotalProduct())
                                                .date(transaction.getId().getDate())
                                                .build())
                                .toList();
                return DataDTO.<TransactionDTO>builder()
                                .data(dataList)
                                .build();
        }

        @Override
        public DataDTO<TransactionDTO> getAllTransactions() {
                List<Transactions> transactionList = transactionRepository.findAll();
                List<TransactionDTO> dataList = transactionList.stream()
                                .map(transaction -> TransactionDTO.builder()
                                                .customer(transaction.getCustomer())
                                                .product(transaction.getProduct())
                                                .price(transaction.getPrice())
                                                .totalProduct(transaction.getTotalProduct())
                                                .date(transaction.getId().getDate())
                                                .build())
                                .toList();
                return DataDTO.<TransactionDTO>builder()
                                .data(dataList)
                                .build();
        }
}