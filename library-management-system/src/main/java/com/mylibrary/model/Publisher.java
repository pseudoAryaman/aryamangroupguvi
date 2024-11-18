package com.mylibrary.model;

public class Publisher {

    private long id;
    private String name;
    private String address;

    // Default constructor
    public Publisher() {}

    // Constructor with parameters
    public Publisher(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{id=" + id + ", name='" + name + "', address='" + address + "'}";
    }
}
