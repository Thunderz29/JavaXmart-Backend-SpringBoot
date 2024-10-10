package com.example.backend_javaxmart.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_javaxmart.dto.CustomerDTO;
import com.example.backend_javaxmart.dto.DataDTO;
import com.example.backend_javaxmart.models.Customers;
import com.example.backend_javaxmart.repositories.CustomerRepo;
import com.example.backend_javaxmart.services.CustomerService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
        @Autowired
        CustomerRepo customerRepo;

        @Override
        public DataDTO<CustomerDTO> getAllCustomer() {
                List<Customers> customerList = customerRepo.findAll();

                List<CustomerDTO> dataList = customerList.stream()
                                .map(customer -> CustomerDTO.builder()
                                                .qrCode(customer.getQrCode())
                                                .name(customer.getName())
                                                .wallet(customer.getWallet())
                                                .build())
                                .toList();

                return DataDTO.<CustomerDTO>builder()
                                .data(dataList)
                                .build();
        }

        @Override
        public CustomerDTO getById(String qrCode) {
                Customers customer = customerRepo.findById(qrCode)
                                .orElseThrow(() -> new EntityNotFoundException(
                                                "Customer with qr code " + qrCode + " not found"));

                return CustomerDTO.builder()
                                .qrCode(customer.getQrCode())
                                .name(customer.getName())
                                .wallet(customer.getWallet())
                                .build();
        }
}
