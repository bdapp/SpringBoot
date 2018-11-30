package me.bello.chapter0303.entity;

import java.io.Serializable;

public class Book implements Serializable {

    private String name;
    private String author;
    private float price;

    public Book() {
    }

    public Book(String name, String author, float price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
