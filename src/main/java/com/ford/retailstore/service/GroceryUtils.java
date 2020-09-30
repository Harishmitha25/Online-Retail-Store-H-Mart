package com.ford.retailstore.service;

import com.ford.retailstore.model.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroceryUtils {

    public static GroceryItem getGroceryDetails(String id) {
        Connection connection = null;
        GroceryItem groceryItem = new GroceryItem();
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from grocery where item_id=?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                groceryItem.setId(resultSet.getString(1));
                groceryItem.setName(resultSet.getString(2));
                groceryItem.setPrice(resultSet.getDouble(3));
                groceryItem.setBrand(resultSet.getString(4));
                groceryItem.setManufactureDate(String.valueOf(resultSet.getDate(5)));
                groceryItem.setBestBeforeDate(String.valueOf(resultSet.getDate(6)));
                groceryItem.setImage(resultSet.getString(7));
                groceryItem.setStock(resultSet.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while getting grocery details");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return groceryItem;
    }

    public static List<GroceryItem> listAllGroceryItems() {
        Connection connection = null;
        List<GroceryItem> itemList = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from grocery");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                GroceryItem groceryItem = new GroceryItem();
                groceryItem.setId(resultSet.getString(1));
                groceryItem.setName(resultSet.getString(2));
                groceryItem.setPrice(resultSet.getDouble(3));
                groceryItem.setBrand(resultSet.getString(4));
                groceryItem.setManufactureDate(String.valueOf(resultSet.getDate(5)));
                groceryItem.setBestBeforeDate(String.valueOf(resultSet.getDate(6)));
                groceryItem.setImage(resultSet.getString(7));
                groceryItem.setStock(resultSet.getInt(8));
                itemList.add(groceryItem);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while listing grocery");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return itemList;
    }
}