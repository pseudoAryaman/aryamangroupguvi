package com.mylibrary.dao;

import com.mylibrary.model.Book;
import java.util.List;

public interface BookDAO {
    // CRUD methods for Book entity
    Book getById(long id);                   // Get Book by ID
    List<Book> getAll();                     // Get all Books
    void save(Book book);                    // Save a new Book
    void update(Book book);                  // Update an existing Book
    void delete(long id);                    // Delete Book by ID
    List<Book> searchByKeyword(String keyword);  // Search Books by keyword (e.g., title or author)
}
