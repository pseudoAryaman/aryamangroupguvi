package com.mylibrary.dao;

import com.mylibrary.model.Category;
import java.util.List;

public interface CategoryDAO {
    Category getById(long id);               // Get Category by ID
    List<Category> getAll();                 // Get all Categories
    void save(Category category);            // Save a new Category
    void update(Category category);          // Update an existing Category
    void delete(long id);                    // Delete Category by ID
}
