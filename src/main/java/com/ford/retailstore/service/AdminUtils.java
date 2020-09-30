package com.ford.retailstore.service;

import com.ford.retailstore.model.DatabaseConnection;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminUtils {
    public static int addGroceryItem(GroceryItem groceryItem) {
        int count=0;
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into grocery(item_id,item_name,item_price,item_brand,item_mfgdate,item_bestbeforedate,item_image,item_stock) values(?,?,?,?,?,?,?,?)");
            statement.setString(1, groceryItem.getId());
            statement.setString(2, groceryItem.getName());
            statement.setDouble(3, groceryItem.getPrice());
            statement.setString(4, groceryItem.getBrand());
            statement.setString(5, groceryItem.getManufactureDate());
            statement.setString(6, groceryItem.getBestBeforeDate());
            statement.setString(7, groceryItem.getImage());
            statement.setInt(8, groceryItem.getStock());
            count=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while adding grocery item");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }

    public static int editGroceryItem(GroceryItem groceryItem) {
        int count=0;
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("update grocery set item_name=?,item_price=?,item_brand=?,item_mfgdate=?,item_bestbeforedate=?,item_image=?,item_stock=? where item_id=?");
            statement.setString(1, groceryItem.getName());
            statement.setDouble(2, groceryItem.getPrice());
            statement.setString(3, groceryItem.getBrand());
            statement.setString(4, groceryItem.getManufactureDate());
            statement.setString(5, groceryItem.getBestBeforeDate());
            statement.setString(6, groceryItem.getImage());
            statement.setInt(7, groceryItem.getStock());
            statement.setString(8, groceryItem.getId());
            count=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while updating grocery item");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }

    public static int deleteGroceryItem(String id){
        int count=0;
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement("delete from grocery where item_id=?");
            statement.setString(1,id);
            count=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting grocery item");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }
    public static int addBook(Book book){
        int count=0;
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into book(book_id,book_name,book_price,book_brand,book_authorname,book_genre,book_image,book_stock) values(?,?,?,?,?,?,?,?)");
            statement.setString(1, book.getId());
            statement.setString(2, book.getName());
            statement.setDouble(3, book.getPrice());
            statement.setString(4, book.getBrand());
            statement.setString(5, book.getAuthorName());
            statement.setString(6, book.getGenre());
            statement.setString(7, book.getImage());
            statement.setInt(8, book.getStock());
            count=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while adding book");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }
    public static int editBook(Book book) {
        int count=0;
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("update book set book_name=?,book_price=?,book_brand=?,book_authorname=?,book_genre=?,book_image=?,book_stock=? where book_id=?");
            statement.setString(1, book.getName());
            statement.setDouble(2, book.getPrice());
            statement.setString(3, book.getBrand());
            statement.setString(4, book.getAuthorName());
            statement.setString(5, book.getGenre());
            statement.setString(6, book.getImage());
            statement.setInt(7, book.getStock());
            statement.setString(8, book.getId());
            count=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while updating book");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }

    public static int deleteBook(String id){
        int count=0;
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement("delete from book where book_id=?");
            statement.setString(1,id);
            count=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting book");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }

    public static int addElectronics(Electronics electronics)  {
        int count=0;
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into electronics(electronics_id,electronics_name,electronics_price,electronics_brand,electronics_devicetype,electronics_powerrating,electronics_image,electronics_stock) values(?,?,?,?,?,?,?,?)");
            statement.setString(1, electronics.getId());
            statement.setString(2, electronics.getName());
            statement.setDouble(3, electronics.getPrice());
            statement.setString(4, electronics.getBrand());
            statement.setString(5, electronics.getDeviceType());
            statement.setString(6, electronics.getPowerRating());
            statement.setString(7, electronics.getImage());
            statement.setInt(8, electronics.getStock());
            count=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while adding electronics");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }

    public static int editElectronics(Electronics electronics) {
        int count=0;
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("update electronics set electronics_name=?,electronics_price=?,electronics_brand=?,electronics_devicetype=?,electronics_powerrating=?,electronics_image=?,electronics_stock=? where electronics_id=?");
            statement.setString(1, electronics.getName());
            statement.setDouble(2, electronics.getPrice());
            statement.setString(3, electronics.getBrand());
            statement.setString(4, electronics.getDeviceType());
            statement.setString(5, electronics.getPowerRating());
            statement.setString(6, electronics.getImage());
            statement.setInt(7, electronics.getStock());
            statement.setString(8, electronics.getId());
            count=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while updating electronics");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }

    public static int deleteElectronics(String id) {
        int count=0;
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement("delete from electronics where electronics_id=?");
            statement.setString(1,id);
            count=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting electronics");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }
    public static int deleteProductOrder(String orderId,String productId) {
        int count=0;
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement("delete from order_detail where order_id=? and id=?");
            statement.setString(1,orderId);
            statement.setString(2,productId);
            count=statement.executeUpdate();
        } catch ( SQLException e) {
            System.out.println("Error occurred while deleting product order");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }
}
