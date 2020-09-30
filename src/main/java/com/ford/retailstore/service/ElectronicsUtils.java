package com.ford.retailstore.service;

import com.ford.retailstore.model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ElectronicsUtils {
    public static Electronics getElectronicsDetails(String id) {
        Connection connection = null;
        Electronics electronics = new Electronics();
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from electronics where electronics_id=?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                electronics.setId(resultSet.getString(1));
                electronics.setName(resultSet.getString(2));
                electronics.setPrice(resultSet.getDouble(3));
                electronics.setBrand(resultSet.getString(4));
                electronics.setDeviceType(String.valueOf(resultSet.getString(5)));
                electronics.setPowerRating(String.valueOf(resultSet.getString(6)));
                electronics.setImage(resultSet.getString(7));
                electronics.setStock(resultSet.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while getting electronics details");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return electronics;
    }

    public static List<Electronics> listAllElectronics() {
        Connection connection = null;
        List<Electronics> itemList = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from electronics");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Electronics electronics = new Electronics();
                electronics.setId(resultSet.getString(1));
                electronics.setName(resultSet.getString(2));
                electronics.setPrice(resultSet.getDouble(3));
                electronics.setBrand(resultSet.getString(4));
                electronics.setDeviceType(String.valueOf(resultSet.getString(5)));
                electronics.setPowerRating(String.valueOf(resultSet.getString(6)));
                electronics.setImage(resultSet.getString(7));
                electronics.setStock(resultSet.getInt(8));
                itemList.add(electronics);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while listing electronics");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return itemList;
    }
}
