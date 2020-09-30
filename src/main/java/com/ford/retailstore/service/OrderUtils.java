package com.ford.retailstore.service;

import com.ford.retailstore.model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderUtils {

    public static int addOrder(String orderId,User user, List<Product> productList) {
        int count = 0;
        for (Product product : productList) {
            try {
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("insert into order_detail (order_id,user_email,user_mobile,user_name,id,name,price,quantity) values (?,?,?,?,?,?,?,?)");
                statement.setString(1, orderId);
                statement.setString(2, user.getEmail());
                statement.setLong(3, user.getMobileNumber());
                statement.setString(4, user.getUserName());
                statement.setString(5, product.getId());
                statement.setString(6, product.getName());
                statement.setDouble(7, product.getPrice());
                statement.setInt(8, product.getQuantity());
                count = statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Exception occurred while adding order");
            }
        }
        return count;
    }

    public static String generateOrderId() {
        int max = 10000;
        int min = 1000;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;
        return "O" + rand;
    }
    public static List<Order> getOrders() {
        List<Order> orderList = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from order_detail");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getString(1));
                order.setUserEmail(resultSet.getString(2));
                order.setUserMobile(resultSet.getLong(3));
                order.setUserName(resultSet.getString(4));
                order.setProductId(resultSet.getString(5));
                order.setProductName(resultSet.getString(6));
                order.setProductPrice(resultSet.getDouble(7));
                order.setProductQuantity(resultSet.getInt(8));
                orderList.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Exception occurred while getting orders");
        }
        return orderList;
    }
}
