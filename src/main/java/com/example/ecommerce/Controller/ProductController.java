package com.example.ecommerce.Controller;

import com.example.ecommerce.Entities.Products;
import com.example.ecommerce.Service.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
}
