package com.example.backend_javaxmart.services;

import com.example.backend_javaxmart.dto.CustomerDTO;
import com.example.backend_javaxmart.dto.DataDTO;

public interface CustomerService {
    DataDTO<CustomerDTO> getAllCustomer();

    CustomerDTO getById(String qrCode);
}