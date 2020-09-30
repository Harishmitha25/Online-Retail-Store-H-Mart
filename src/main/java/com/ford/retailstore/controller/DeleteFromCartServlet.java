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

@WebServlet("/deleteProductFromCart")
public class DeleteFromCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("email");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");

        Product product = null;
        if (id.startsWith("G")) {
            product = GroceryUtils.getGroceryDetails(id);
        } else if (id.startsWith("B")) {
            product = BookUtils.getBookDetails(id);
        } else {
            product = BookUtils.getBookDetails(id);
        }

        int count = CartUtils.deleteProductFromCart(product, userEmail);

        if (count > 0) {
            out.println("<html><script type='text/javascript' src='js/product_deletion_success.js'></script></html>");
        } else {
            out.println("<html><script type='text/javascript' src='js/delete_product_failure.js'></script></html>");
        }
        out.close();
    }
}
