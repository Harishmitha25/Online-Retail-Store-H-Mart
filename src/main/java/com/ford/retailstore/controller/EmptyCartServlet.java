package com.ford.retailstore.controller;

import com.ford.retailstore.service.CartUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/emptyCart")
public class EmptyCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("email");
        int count = CartUtils.emptyCart(userEmail);
        if (count > 0) {
            out.println("<html><script type='text/javascript' src='js/empty_cart_success.js'></script></html>");
        } else {
            out.println("<html><script type='text/javascript' src='js/empty_cart_failure.js'></script></html>");
        }
        out.close();
    }
}
