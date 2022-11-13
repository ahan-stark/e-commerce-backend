package com.example.ecommerce.Service;

import com.example.ecommerce.Entities.Products;
import com.example.ecommerce.Repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public void addProducts(Products products) {
        productsRepository.save(products);
    }

    public List<Products> getProducts(Integer productCategoryId) {
       return productsRepository.findAllByproductCategoryId(productCategoryId);

    }
}
