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

@WebServlet("/cartCheck")
public class CheckLoginAndAddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String id = request.getParameter("id");

        HttpSession session = request.getSession();
        String check = (String) session.getAttribute("loginCheck");
        String userEmail = (String) session.getAttribute("email");

        if (check != null) {
            Product product = null;
            if (id.startsWith("G")) {
                product = GroceryUtils.getGroceryDetails(id);
            } else if (id.startsWith("B")) {
                product = BookUtils.getBookDetails(id);
            } else {
                product = ElectronicsUtils.getElectronicsDetails(id);
            }

            int count = CartUtils.addProductToCart(product, quantity, userEmail);

            if (count > 0) {
                response.sendRedirect("Cart.jsp");
            } else {
                out.println("<html><head><script type='text/javascript' src='js/cannot_add_product.js'></script></head></html>");
            }
        } else {
            out.println("<html><head><script type='text/javascript' src='js/login_check.js'></script></head></html>");
        }
        out.close();
    }
}
