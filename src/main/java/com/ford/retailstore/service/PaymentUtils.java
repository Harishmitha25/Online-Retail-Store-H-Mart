package com.ford.retailstore.service;

import com.ford.retailstore.model.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentUtils {

    public static int addPaymentDetails(String orderId, User user, double total, String paymentMode) {
        Connection connection = null;
        int count=0;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement("insert into payment (order_id,user_name,user_email,user_mobile,total_amount_paid,payment_mode) values (?,?,?,?,?,?)");
            statement.setString(1,orderId);
            statement.setString(2,user.getUserName());
            statement.setString(3,user.getEmail());
            statement.setLong(4,user.getMobileNumber());
            statement.setDouble(5,total);
            statement.setString(6,paymentMode);
            count=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while adding payment details");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }
    public static List<Payment> getPaymentDetails() {
        Connection connection = null;
        List<Payment> paymentList = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from payment");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setOrderId(resultSet.getString(1));
                payment.setUserName(resultSet.getString(2));
                payment.setUserEmail(resultSet.getString(3));
                payment.setUserMobile(resultSet.getLong(4));
                payment.setTotal(resultSet.getDouble(5));
                payment.setPaymentMode(resultSet.getString(6));
                paymentList.add(payment);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while getting payment details");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return paymentList;
    }
}
