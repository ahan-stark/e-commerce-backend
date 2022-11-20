package com.example.ecommerce.repository.products;

import com.example.ecommerce.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    List<Products> findAllByproductCategoryId(Integer productCategoryId);
}
