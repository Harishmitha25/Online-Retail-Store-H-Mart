package com.ford.retailstore.service;

public class Book extends Product {
    private String authorName;
    private String genre;
    public Book(){

    }

    public Book(String authorName, String genre) {
        this.authorName = authorName;
        this.genre = genre;
    }

    public Book(String id, String name, double price, String brand, int requiredQuantity, String image, int stock, String authorName, String genre) {
        super(id, name, price, brand, requiredQuantity, image, stock);
        this.authorName = authorName;
        this.genre = genre;
    }

    public Book(String id, String name, double price, String brand, String authorName, String genre, String image, int stock) {
        super(id, name, price, brand, image, stock);
        this.authorName = authorName;
        this.genre = genre;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorName='" + authorName + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
