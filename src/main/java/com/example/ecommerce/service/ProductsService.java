package com.example.ecommerce.service;

import com.example.ecommerce.entities.Products;
import com.example.ecommerce.repository.products.ProductsQueryImplementation;
import com.example.ecommerce.repository.products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    ProductsRepository productsRepository;
    @Autowired
    ProductsQueryImplementation productsQueryImplementation;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public void addProducts(Products products) {
        productsRepository.save(products);
    }

    public List<Products> getProducts(int productCategoryId) {
        return productsQueryImplementation.getProductByCategoryId(productCategoryId);

    }
}
