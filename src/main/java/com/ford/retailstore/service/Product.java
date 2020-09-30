package com.ford.retailstore.service;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String id;
    private String name;
    private double price;
    private String brand;
    private int quantity;
    private String image;
    private int stock;
    static List<Product> productList = new ArrayList<>();

    public Product() {

    }

    public Product(String id, String name, double price, String brand, int quantity, String image, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.quantity = quantity;
        this.image = image;
        this.stock = stock;
    }

    public Product(String id, String name, double price, String brand, String image, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.image = image;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static List<Product> getProductList() {
        return productList;
    }

    public static void setProductList(List<Product> productList) {
        Product.productList = productList;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                ", stock=" + stock +
                '}';
    }
}

