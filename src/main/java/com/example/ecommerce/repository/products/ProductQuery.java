package com.example.ecommerce.repository.products;

import com.example.ecommerce.entities.Products;

import java.util.List;

public interface ProductQuery {
    List<Products> getProductByCategoryId(int id);
    Products getIndividualProduct(int id);
    List<Products> getMobileProducts();
    public List<Products> getTrendyProducts();

}
