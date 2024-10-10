package com.example.backend_javaxmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.backend_javaxmart.dto.DataDTO;
import com.example.backend_javaxmart.dto.ProductDTO;
import com.example.backend_javaxmart.services.ProductService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<DataDTO<ProductDTO>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/{rfid}")
    public ResponseEntity<ProductDTO> detailBarang(@PathVariable String rfid) {
        try {
            return ResponseEntity.ok(productService.getById(rfid));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
