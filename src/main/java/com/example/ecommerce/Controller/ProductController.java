package com.example.ecommerce.Controller;

import com.example.ecommerce.Entities.Products;
import com.example.ecommerce.Service.ProductsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductController {
    ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/addProducts")
    public void addProducts(@RequestBody Products products) {
        productsService.addProducts(products);
    }
}
