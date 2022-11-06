package com.example.ecommerce.Service;

import com.example.ecommerce.Entities.Products;
import com.example.ecommerce.Repository.ProductsRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public void addProducts(Products products) {
        productsRepository.save(products);
    }

}
