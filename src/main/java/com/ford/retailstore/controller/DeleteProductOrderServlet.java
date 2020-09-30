package com.ford.retailstore.controller;

import com.ford.retailstore.service.AdminUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteProductOrder")
public class DeleteProductOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String orderId = request.getParameter("orderId");
        String productId = request.getParameter("productId");
        int count = AdminUtils.deleteProductOrder(orderId, productId);
        if (count > 0) {
            response.sendRedirect("OrderDetails.jsp");
        } else {
            out.println("<html><script type='text/javascript' src='js/product_order_deletion_failure.js'></script></html>");
        }
        out.close();
    }
}
