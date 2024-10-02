package com.example.kudago.service;

import com.example.kudago.model.Category;
import com.example.kudago.repo.CategoryRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepository;
    public Collection<Category> getAllCategories() {
        return categoryRepository.getAllCategories().values();
    }
    public Category getCategoryById(Integer id) {
        return categoryRepository.getCategoryById(id);
    }
    public Category addCategory(Category category) {categoryRepository.addCategory(category);
        return category;
    }
    public void updateCategory(Integer id, Category category) {
        categoryRepository.updateCategory(id, category);
    }
    public void deleteCategory(Integer id) {
        categoryRepository.deleteCategory(id);
    }

}