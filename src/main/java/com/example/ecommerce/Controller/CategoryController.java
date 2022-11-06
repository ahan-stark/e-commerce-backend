package com.example.ecommerce.Controller;

import com.example.ecommerce.Entities.Category;
import com.example.ecommerce.Service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/addCategory")
    public void addCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }
}
