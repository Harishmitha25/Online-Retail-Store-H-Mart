package com.ford.retailstore;

public class AdminLoginFailedException extends Throwable {
    public static String invalidCredentials(){
        return "Invalid username or password.";
    }
}
