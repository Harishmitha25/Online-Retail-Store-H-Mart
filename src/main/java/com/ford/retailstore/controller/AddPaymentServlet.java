package com.ford.retailstore.controller;

import com.ford.retailstore.service.PaymentUtils;
import com.ford.retailstore.service.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addPayment")
public class AddPaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paymentMode = req.getParameter("mode");
        String orderId = req.getParameter("id");
        double total = Double.parseDouble(req.getParameter("total"));

        HttpSession session = req.getSession();
        String userEmail = (String) session.getAttribute("email");
        long mobileNumber = (long) req.getSession().getAttribute("mobile");
        String userName = (String) session.getAttribute("userName");

        User user = new User(userEmail, mobileNumber, userName);

        PaymentUtils.addPaymentDetails(orderId, user, total, paymentMode);
        if (paymentMode.equals("Net Banking")) {
            resp.sendRedirect("/paymentByNetBankingServlet");
        } else if (paymentMode.equals("UPI")) {
            resp.sendRedirect("/paymentByUPIServlet");
        }
    }
}
