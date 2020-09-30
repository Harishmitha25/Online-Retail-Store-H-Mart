package com.ford.retailstore.service;

import com.ford.retailstore.model.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartUtils {
   public static int addProductToCart(Product product, int quantity,String userEmail) {
       Connection connection = null;
       int count = 0;
       product.setQuantity(quantity);
       boolean check=checkPresencOfProductInCart(product,userEmail);
       if(!check) {
           try {
               connection = DatabaseConnection.getConnection();
               PreparedStatement statement = connection.prepareStatement("insert into cart(item_id,item_name,item_price,item_brand,item_image,item_requiredQty,user_email) values(?,?,?,?,?,?,?)");
               statement.setString(1, product.getId());
               statement.setString(2, product.getName());
               statement.setDouble(3, product.getPrice());
               statement.setString(4, product.getBrand());
               statement.setString(5, product.getImage());
               statement.setInt(6, product.getQuantity());
               statement.setString(7, userEmail);
               count = statement.executeUpdate();
           } catch (SQLException e) {
               System.out.println("Error occurred while adding product to cart");
           } finally {
               DatabaseConnection.closeConnection(connection);
           }
           return count;
       }
       else{
           return 0;
       }
   }
    public static List<Product> getProductsFromCart(String userEmail) {
        Connection connection = null;
        List<Product> itemList = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from cart where user_email=?");
            statement.setString(1, userEmail);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getString(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));
                product.setBrand(resultSet.getString(4));
                product.setImage(resultSet.getString(5));
                product.setQuantity(resultSet.getInt(6));
                itemList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while getting products from cart");
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return itemList;
    }
    private static boolean checkPresencOfProductInCart(Product product,String userEmail) {
        List<Product> itemList=getProductsFromCart(userEmail);
        for(Product productRef:itemList){
            if(productRef.getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    public static int deleteProductFromCart(Product product,String userEmail) {
        Connection connection = null;
        int count = 0;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from cart where item_id=? and user_email=?");
            statement.setString(1, product.getId());
            statement.setString(2, userEmail);
            count = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting product in cart");
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }

    public static int emptyCart(String userEmail) {
        Connection connection = null;
        int count = 0;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from cart where user_email=?");
            statement.setString(1,userEmail);
            count = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while emptying cart");
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }

    public static int updateQuantity(Product product, int quantity,String userEmail) {
        Connection connection = null;
        int count = 0;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("update cart set item_requiredQty=? where item_id=? and user_email=?");
            statement.setInt(1, quantity);
            statement.setString(2, product.getId());
            statement.setString(3,userEmail);
            count = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while updating product in cart");
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return count;
    }
}
