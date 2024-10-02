package com.example.kudago.repo;

import com.example.kudago.model.Category;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CategoryRepo {
    private int currentId = 1;
    private ConcurrentHashMap<Integer, Category> categoryStore = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Integer, Category> getAllCategories() {
        return categoryStore;
    }
    public Category getCategoryById(Integer id) {
        return categoryStore.get(id);
    }
    public void addCategory(Category category) {
        categoryStore.put(category.getId(), category);
    }
    public void updateCategory(Integer id, Category category) {
        categoryStore.put(id, category);
    }
    public void deleteCategory(Integer id) {
        categoryStore.remove(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            category.setId(currentId++);
        }
        categoryStore.put(category.getId(), category);
        return category;
    }


}
