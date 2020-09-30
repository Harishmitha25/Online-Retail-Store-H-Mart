package com.ford.retailstore.model;

import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver:// ito078635.hosts.cloud.ford.com:1433", "javatraining_db_appl", "Anabaena25!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}