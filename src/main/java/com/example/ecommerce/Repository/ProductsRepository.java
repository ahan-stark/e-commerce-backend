package com.example.ecommerce.Repository;

import com.example.ecommerce.Entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    List<Products> findAllByproductCategoryId(Integer productCategoryId);
}
