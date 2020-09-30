package com.ford.retailstore.service;

public class Electronics extends Product {
    private String deviceType;
    private String powerRating;

    public Electronics(){

    }

    public Electronics(String deviceType, String powerRating) {
        this.deviceType = deviceType;
        this.powerRating = powerRating;
    }

    public Electronics(String id, String name, double price, String brand, int requiredQuantity, String image, int stock, String deviceType, String powerRating) {
        super(id, name, price, brand, requiredQuantity, image, stock);
        this.deviceType = deviceType;
        this.powerRating = powerRating;
    }

    public Electronics(String id, String name, double price, String brand, String deviceType, String powerRating ,String image, int stock) {
        super(id, name, price, brand, image, stock);
        this.deviceType = deviceType;
        this.powerRating = powerRating;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getPowerRating() {
        return powerRating;
    }

    public void setPowerRating(String powerRating) {
        this.powerRating = powerRating;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "deviceType='" + deviceType + '\'' +
                ", powerRating='" + powerRating + '\'' +
                '}';
    }
}
