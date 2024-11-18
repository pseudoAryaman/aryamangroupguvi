package com.mylibrary.model;

import java.util.Date;

public class Book {

    private long id;
    private String title;
    private Author author;
    private Category category;
    private Publisher publisher;
    private Date publishDate;
    private String isbn;

    // Default constructor
    public Book() {}

    // Constructor with parameters
    public Book(long id, String title, Author author, Category category, Publisher publisher, Date publishDate, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.isbn = isbn;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {  // Change return type to Date
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author=" + author + ", category=" + category + ", publisher=" + publisher + ", publishDate=" + publishDate + ", isbn='" + isbn + "'}";
    }
}
