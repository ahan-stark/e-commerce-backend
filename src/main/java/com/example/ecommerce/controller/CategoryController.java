package com.example.ecommerce.controller;

import com.example.ecommerce.entities.Category;
import com.example.ecommerce.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public void addCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @GetMapping("/categories")
    public List<Category> getCategory() {
        return categoryService.getCategories();
    }
}
