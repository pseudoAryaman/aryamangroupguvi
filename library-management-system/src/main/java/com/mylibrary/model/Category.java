package com.mylibrary.model;

public class Category {

    private long id;
    private String name;

    // Default constructor
    public Category() {}

    // Constructor with parameters
    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{id=" + id + ", name='" + name + "'}";
    }
}
