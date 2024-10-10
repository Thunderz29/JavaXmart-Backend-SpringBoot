package com.example.backend_javaxmart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend_javaxmart.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
}
