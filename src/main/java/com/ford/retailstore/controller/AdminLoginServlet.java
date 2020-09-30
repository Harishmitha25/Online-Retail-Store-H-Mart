package com.ford.retailstore.controller;

import com.ford.retailstore.AdminLoginFailedException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if (userName.equals("admin") && password.equals("admin@123")) {
            response.sendRedirect("AdminIndex.jsp");
        } else {
            response.sendRedirect("AdminLoginFail.jsp");
        }
    }
}


