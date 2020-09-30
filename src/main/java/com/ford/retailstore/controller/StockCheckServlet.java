package com.ford.retailstore.controller;

import com.ford.retailstore.service.StockUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/stockCheck")
public class StockCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String type = request.getParameter("submit");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String id = request.getParameter("id");
        int stock = StockUtils.getStockValue(id);

        if (stock > quantity && type.equals("Add to Cart")) {
            out.println("<html><head><script id='stock' type='text/javascript' data-id='" + id + "' data-quantity='" + quantity + "' src='js/quantity_available.js'></script></head></html>");
        } else if (stock > quantity && type.equals("Update")) {
            out.println("<html><head><script id='stock' type='text/javascript'  data-id='" + id + "' data-quantity='" + quantity + "' src='js/update_quantity_available.js'></script></head></html>");
        } else {
            if (id.startsWith("G")) {
                out.println("<html><head><script id='id' type='text/javascript' data-id='" + id + "' data-quantity='" + quantity + "'src='js/grocery_quantity_not_available.js'></script></head></html>");
            } else if (id.startsWith("B")) {
                out.println("<html><head><script id='id' type='text/javascript' data-id='" + id + "' data-quantity='" + quantity + "'src='js/book_quantity_not_available.js'></script></head></html>");
            } else if (id.startsWith("E")) {
                out.println("<html><head><script id='id' type='text/javascript' data-id='" + id + "' data-quantity='" + quantity + "'src='js/electronics_quantity_not_available.js'></script></head></html>");
            }
        }
        out.close();
    }
}

