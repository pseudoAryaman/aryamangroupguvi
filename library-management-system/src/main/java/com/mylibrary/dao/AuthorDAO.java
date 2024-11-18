package com.mylibrary.dao;

import com.mylibrary.model.Author;
import java.util.List;

public interface AuthorDAO {
    // CRUD methods for Author entity
    Author getById(long id);               // Get Author by ID
    List<Author> getAll();                 // Get all Authors
    void save(Author author);              // Save a new Author
    void update(Author author);            // Update an existing Author
    void delete(long id);                  // Delete Author by ID
}
