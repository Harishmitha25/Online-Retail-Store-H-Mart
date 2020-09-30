package com.ford.retailstore.controller;

import com.ford.retailstore.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productAvailabilityCheck")
public class ProductAvailabilityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String orderId = request.getParameter("orderId");
        String productId = request.getParameter("productId");

        if (productId.startsWith("G")) {
            List<GroceryItem> groceryItemList = GroceryUtils.listAllGroceryItems();
            for (GroceryItem item : groceryItemList) {
                if (item.getId().equals(productId)) {
                    out.println("<html><script type='text/javascript' src='js/cannot_delete_product_order.js'></script></html>");
                }
            }
            out.println("<html><script id='order' type='text/javascript' data-order-id='" + orderId + "' data-product-id='" + productId + "' src='js/delete_product_order.js'></script></html>");
        } else if (productId.startsWith("B")) {
            List<Book> bookList = BookUtils.listAllBooks();
            for (Book book : bookList) {
                if (book.getId().equals(productId)) {
                    out.println("<html><script type='text/javascript' src='js/cannot_delete_product_order.js'></script></html>");
                }
            }
            out.println("<html><script id='order' type='text/javascript' data-order-id='" + orderId + "' data-product-id='" + productId + "' src='js/delete_product_order.js'></script></html>");
        } else if (productId.startsWith("E")) {
            List<Electronics> electronicsList = ElectronicsUtils.listAllElectronics();
            for (Electronics electronics : electronicsList) {
                if (electronics.getId().equals(productId)) {
                    out.println("<html><script type='text/javascript' src='js/cannot_delete_product_order.js'></script></html>");
                }
            }
            out.println("<html><script id='order' type='text/javascript' data-order-id='" + orderId + "' data-product-id='" + productId + "' src='js/delete_product_order.js'></script></html>");
        }
        out.close();
    }
}
