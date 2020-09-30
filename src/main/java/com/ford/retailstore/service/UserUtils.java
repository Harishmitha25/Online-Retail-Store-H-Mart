package com.ford.retailstore.service;

import com.ford.retailstore.model.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserUtils {

    public static int addUser(User user) {
        Connection connection = null;
        int count = 0;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into registration(email,mobile_number,user_name,password) values(?,?,?,?)");
            statement.setString(1, user.getEmail());
            statement.setLong(2, user.getMobileNumber());
            statement.setString(3, user.getUserName());
            statement.setString(4, user.getPassword());
            count = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while adding user");
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }

    public static List<User> getUsers() {
        Connection connection = null;
        List<User> usersList = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from registration");
            while (resultSet.next()) {
                User userObject = new User();
                userObject.setEmail(resultSet.getString(1));
                userObject.setMobileNumber(resultSet.getLong(2));
                userObject.setUserName(resultSet.getString(3));
                userObject.setPassword(resultSet.getString(4));
                usersList.add(userObject);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while listing users");
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return usersList;
    }
}
