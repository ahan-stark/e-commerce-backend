package com.example.ecommerce.Repository;

import com.example.ecommerce.Entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Integer> {
}