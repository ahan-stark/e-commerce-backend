package com.example.ecommerce.controller;

import com.example.ecommerce.entities.Products;
import com.example.ecommerce.service.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {
    ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/products")
    public void addProducts(@RequestBody Products products) {
        productsService.addProducts(products);
    }

    @GetMapping("/products/{productCategoryId}")
    public List<Products> getProducts(@PathVariable("productCategoryId") Integer productCategoryId) {
        return productsService.getProducts(productCategoryId);
    }

    @GetMapping("product-view/{productId}")
    public Products getIndividualProducts(@PathVariable("productId") Integer productId) {
        return productsService.getIndividualProduct(productId);
    }
    @GetMapping("get-mobiles")
    public List<Products> getMobileProducts(){
        return productsService.getMobileProducts();
    }
    @GetMapping("trendy-products")
    public List<Products> getTrendyProducts(){
        return productsService.getTrendyProducts();
    }
}

