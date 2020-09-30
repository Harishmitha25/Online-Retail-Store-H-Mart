package com.ford.retailstore.service;

public class Payment {
    private String orderId;
    private String userEmail;
    private long userMobile;
    private String userName;
    private double total;
    private String paymentMode;

    public Payment() {
    }

    public Payment(String orderId, String userEmail, long userMobile, String userName, double total, String paymentMode) {
        this.orderId = orderId;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.userName = userName;
        this.total = total;
        this.paymentMode = paymentMode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(long userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

}
