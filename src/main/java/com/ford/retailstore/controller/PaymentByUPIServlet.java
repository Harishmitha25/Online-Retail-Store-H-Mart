package com.ford.retailstore.controller;

import com.ford.retailstore.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/paymentByUPIServlet")
public class PaymentByUPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UPI paymentByUPI = new UPI();
        String upiId = paymentByUPI.pay();

        PrintWriter printWriter = resp.getWriter();

        printWriter.println("<html><head><link rel='stylesheet' href='css/payment.css'></head>");

        printWriter.println( "<body>" +
                "<a class='top' href='/home.html'>Continue Shopping</a>"+
                "<a class='top' href='/userLogoutServlet'>Logout</a>"+
                "<h2>Payment Successful!!!</h2>" +
                "<h3>Transaction ID : " + upiId + "</h3>" +
                "<h2>Order Summary</h2>" +
                "<table><th>Name</th><th>Quantity</th><th>Price</th><th>Amount</th>");
        HttpSession session = req.getSession();
        String userEmail = (String) session.getAttribute("email");
        List<Product> productList = CartUtils.getProductsFromCart(userEmail);

        int total = 0;
        for (Product item : productList) {
            total += item.getQuantity() * item.getPrice();
            printWriter.println(
                    "<tr><td>" + item.getName() + "</td>" +
                            "<td>" + item.getQuantity() + "</td>" +
                            "<td>" + item.getPrice() + "</td>" +
                            " <td>" + item.getQuantity() * item.getPrice() + "</td></tr>" +
                            "<br>");
        }
        printWriter.println("<h3>Total : " + total + "</h3></body></html>");
        StockUtils.updateStock(productList);
        CartUtils.emptyCart(userEmail);
        printWriter.close();
    }
}
