package com.mylibrary.model;

public class Author {

    private long id;
    private String name;
    private String biography;

    // Default constructor
    public Author() {}

    // Constructor with parameters
    public Author(long id, String name, String biography) {
        this.id = id;
        this.name = name;
        this.biography = biography;
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Author{id=" + id + ", name='" + name + "', biography='" + biography + "'}";
    }
}
