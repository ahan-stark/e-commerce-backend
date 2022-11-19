package com.example.ecommerce.Repository.Products;

import com.example.ecommerce.Entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    List<Products> findAllByproductCategoryId(Integer productCategoryId);
}
