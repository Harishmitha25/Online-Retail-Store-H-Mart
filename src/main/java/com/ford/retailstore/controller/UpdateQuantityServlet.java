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

@WebServlet("/updateQuantity")
public class UpdateQuantityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("email");
        PrintWriter out = response.getWriter();
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String id = request.getParameter("id");

        Product product = null;
        if (id.startsWith("G")) {
            product = GroceryUtils.getGroceryDetails(id);
        } else if (id.startsWith("B")) {
            product = BookUtils.getBookDetails(id);
        } else {
            product = ElectronicsUtils.getElectronicsDetails(id);
        }

        int count = CartUtils.updateQuantity(product, quantity, userEmail);

        if (count > 0) {
            out.println("<html><head><script type='text/javascript' src='js/quantity_update_success.js'></script></head></html>");
        } else {
            out.println("<html><head><script type='text/javascript' src='js/quantity_update_failure.js'></script></head></html>");
        }
        out.close();
    }
}
