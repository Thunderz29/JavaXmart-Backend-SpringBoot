package com.example.backend_javaxmart.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_javaxmart.dto.DataDTO;
import com.example.backend_javaxmart.dto.ProductDTO;
import com.example.backend_javaxmart.models.Product;
import com.example.backend_javaxmart.repositories.ProductRepo;
import com.example.backend_javaxmart.services.ProductService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {
        @Autowired
        ProductRepo productRepo;

        @Override
        public DataDTO<ProductDTO> getAllProduct() {
                List<Product> productList = productRepo.findAll();

                List<ProductDTO> dataList = productList.stream()
                                .map(product -> ProductDTO.builder()
                                                .rfid(product.getRfid())
                                                .productName(product.getProductName())
                                                .price(product.getPrice())
                                                .build())
                                .toList();

                return DataDTO.<ProductDTO>builder()
                                .data(dataList)
                                .build();
        }

        @Override
        public ProductDTO getById(String rfid) {
                Product product = productRepo.findById(rfid)
                                .orElseThrow(() -> new EntityNotFoundException(
                                                "Product with rfid " + rfid + " not found"));

                return ProductDTO.builder()
                                .rfid(product.getRfid())
                                .productName(product.getProductName())
                                .price(product.getPrice())
                                .build();
        }
}