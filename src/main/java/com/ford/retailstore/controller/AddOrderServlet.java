package com.ford.retailstore.controller;

import com.ford.retailstore.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/addOrder")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userEmail = (String) session.getAttribute("email");
        String mobileNumber =  String.valueOf(req.getSession().getAttribute("mobile"));
        String userName = (String) session.getAttribute("userName");
        List<Product> productList = CartUtils.getProductsFromCart(userEmail);

        String paymentMode = req.getParameter("mode");
        String total = req.getParameter("total");

        User user = new User(userEmail, Long.parseLong(mobileNumber), userName);

        Order order = new Order();
        String orderId = OrderUtils.generateOrderId();
        order.setOrderId(orderId);

        OrderUtils.addOrder(orderId, user, productList);
        resp.sendRedirect("/addPayment?id=" + orderId + "&mode=" + paymentMode + "&total=" + total);
    }
}
