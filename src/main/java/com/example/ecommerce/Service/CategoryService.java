package com.example.ecommerce.Service;

import com.example.ecommerce.Entities.Category;
import com.example.ecommerce.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
