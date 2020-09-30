package com.ford.retailstore.controller;

import com.ford.retailstore.service.Order;
import com.ford.retailstore.service.OrderUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/orderReport")
public class OrderReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        List<Order> orderList = OrderUtils.getOrders();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter("C:\\ford\\OnlineRetailStore\\src\\main\\java\\com\\ford\\retailstore\\Orders Report.csv");
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("Order ID,User Email,User Mobile,User Name,Product Id,Product Name,Product Price,Product Quantity");
            for (Order order : orderList) {
                printWriter.println(order.getOrderId() + "," + order.getUserEmail() + "," + order.getUserMobile() + "," + order.getUserName() + "," + order.getProductId() + "," + order.getProductName() + "," + order.getProductPrice() + "," + order.getProductQuantity());
            }
            out.println("<html><head><script type='text/javascript' src='js/download_order.js'></script></html>");
        } catch (IOException e) {
            System.out.println("Error occurred while downloading order report");
        } finally {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        }
    }
}
