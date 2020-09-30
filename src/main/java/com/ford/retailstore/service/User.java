package com.ford.retailstore.service;

import org.apache.catalina.Session;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private long mobileNumber;
    private String userName;
    private String password;
    public static List<Session> sessions=new ArrayList<>();
    public User() {
    }

    public User(String email, long mobileNumber, String userName, String password) {
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userEmail, long mobileNumber, String userName) {
        this.email = userEmail;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
