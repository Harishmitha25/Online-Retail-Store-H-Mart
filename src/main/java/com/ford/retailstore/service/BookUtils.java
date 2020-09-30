package com.ford.retailstore.service;

import com.ford.retailstore.model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookUtils {
    public static Book getBookDetails(String id)  {
        Book book = new Book();
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from book where book_id=?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                book.setId(resultSet.getString(1));
                book.setName(resultSet.getString(2));
                book.setPrice(resultSet.getDouble(3));
                book.setBrand(resultSet.getString(4));
                book.setAuthorName(resultSet.getString(5));
                book.setGenre(resultSet.getString(6));
                book.setImage(resultSet.getString(7));
                book.setStock(resultSet.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while getting book details");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return book;
    }

    public static List<Book> listAllBooks() {
        List<Book> bookList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from book");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getString(1));
                book.setName(resultSet.getString(2));
                book.setPrice(resultSet.getDouble(3));
                book.setBrand(resultSet.getString(4));
                book.setAuthorName(resultSet.getString(5));
                book.setGenre(resultSet.getString(6));
                book.setImage(resultSet.getString(7));
                book.setStock(resultSet.getInt(8));
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while listing books");
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return bookList;
    }
}
