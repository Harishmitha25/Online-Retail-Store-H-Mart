package com.ford.retailstore.service;

public class GroceryItem extends Product {
    private String manufactureDate;
    private String bestBeforeDate;

    public GroceryItem() {

    }

    public GroceryItem(String manufactureDate, String bestBeforeDate) {
        this.manufactureDate = manufactureDate;
        this.bestBeforeDate = bestBeforeDate;
    }

    public GroceryItem(String id, String name, double price, String brand, String manufactureDate, String bestBeforeDate, String image, int stock) {
        super(id, name, price, brand,image, stock);
        this.manufactureDate = manufactureDate;
        this.bestBeforeDate = bestBeforeDate;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getBestBeforeDate() {
        return bestBeforeDate;
    }

    public void setBestBeforeDate(String bestBeforeDate) {
        this.bestBeforeDate = bestBeforeDate;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "manufactureDate='" + manufactureDate + '\'' +
                ", bestBeforeDate='" + bestBeforeDate + '\'' +
                ",id='"+this.getId()+
                '}';
    }
}
