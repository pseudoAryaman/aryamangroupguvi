package com.mylibrary.dao;

import com.mylibrary.model.Publisher;
import java.util.List;

public interface PublisherDAO {
    Publisher getById(long id);               // Get Publisher by ID
    List<Publisher> getAll();                 // Get all Publishers
    void save(Publisher publisher);           // Save a new Publisher
    void update(Publisher publisher);         // Update an existing Publisher
    void delete(long id);                     // Delete Publisher by ID
}
