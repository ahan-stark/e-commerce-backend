package com.example.ecommerce.Repository.Products;

import com.example.ecommerce.Entities.Products;

import java.util.List;

public interface ProductQuery {
    List<Products> getProductByCategoryId(int id);

}
