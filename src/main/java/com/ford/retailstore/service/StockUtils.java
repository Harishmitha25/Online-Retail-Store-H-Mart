package com.ford.retailstore.service;

import com.ford.retailstore.model.DatabaseConnection;

import java.sql.*;
import java.util.List;

public class StockUtils {
    public static int getStockValue(String id) {
        Connection connection = null;
        if (id.startsWith("G")) {
            GroceryItem groceryItem = new GroceryItem();
            try {
                connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("select item_stock from grocery where item_id=?");
                statement.setString(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    groceryItem.setStock(resultSet.getInt(1));
                }
            } catch (SQLException e) {
                System.out.println("Error occurred while getting stock value");
            } finally {
                DatabaseConnection.closeConnection(connection);
            }
            return groceryItem.getStock();
        } else if (id.startsWith("B")) {
            Book book = new Book();
            try {
                connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("select book_stock from book where book_id=?");
                statement.setString(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    book.setStock(resultSet.getInt(1));
                }
            } catch (SQLException e) {
                System.out.println("Error occurred while getting stock value");
            } finally {
                DatabaseConnection.closeConnection(connection);
            }
            return book.getStock();
        } else {
            Electronics electronics = new Electronics();
            try {
                connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("select electronics_stock from electronics where electronics_id=?");
                statement.setString(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    electronics.setStock(resultSet.getInt(1));
                }
            } catch (SQLException e) {
                System.out.println("Error occurred while getting stock value");
            } finally {
                DatabaseConnection.closeConnection(connection);
            }
            return electronics.getStock();
        }
    }


    public static void updateStock(List<Product> productList) {
        Connection connection = null;
        for (Product product : productList) {
            if (product.getId().startsWith("G")) {
                int quantity = product.getQuantity();
                int stockValue=getStockValue(product.getId());
                int updatedStock=stockValue-quantity;
                try {
                    connection = DatabaseConnection.getConnection();
                    PreparedStatement statement = connection.prepareStatement("update grocery set item_stock=? where item_id=?");
                    statement.setInt(1, updatedStock);
                    statement.setString(2, product.getId());
                    statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error occurred while updating stock");
                }
            }

            else if (product.getId().startsWith("B")) {
                int quantity = product.getQuantity();
                int stockValue=getStockValue(product.getId());
                int updatedStock=stockValue-quantity;
                try {
                    connection = DatabaseConnection.getConnection();
                    PreparedStatement statement = connection.prepareStatement("update book set book_stock=? where book_id=?");
                    statement.setInt(1, updatedStock);
                    statement.setString(2, product.getId());
                    statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error occurred while updating stock");
                }
            }

            else if (product.getId().startsWith("E")) {
                int quantity = product.getQuantity();
                int stockValue=getStockValue(product.getId());
                int updatedStock=stockValue-quantity;
                try {
                    connection = DatabaseConnection.getConnection();
                    PreparedStatement statement = connection.prepareStatement("update electronics set electronics_stock=? where electronics_id=?");
                    statement.setInt(1, updatedStock);
                    statement.setString(2, product.getId());
                    statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error occurred while updating stock");
                }
            }
        }
    }
}

