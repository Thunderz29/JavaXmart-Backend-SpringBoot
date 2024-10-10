package com.example.backend_javaxmart.services;

import com.example.backend_javaxmart.dto.DataDTO;
import com.example.backend_javaxmart.dto.ProductDTO;

public interface ProductService {
    DataDTO<ProductDTO> getAllProduct();

    ProductDTO getById(String rfid);
}
