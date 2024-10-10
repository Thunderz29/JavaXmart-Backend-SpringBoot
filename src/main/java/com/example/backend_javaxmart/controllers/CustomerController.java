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

import com.example.backend_javaxmart.dto.CustomerDTO;
import com.example.backend_javaxmart.dto.DataDTO;
import com.example.backend_javaxmart.services.CustomerService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<DataDTO<CustomerDTO>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/{qrCode}")
    public ResponseEntity<CustomerDTO> detailCustomer(@PathVariable String qrCode) {
        try {
            return ResponseEntity.ok(customerService.getById(qrCode));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}