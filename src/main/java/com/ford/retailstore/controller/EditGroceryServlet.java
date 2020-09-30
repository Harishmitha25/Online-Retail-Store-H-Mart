package com.ford.retailstore.controller;

import com.ford.retailstore.service.AdminUtils;
import com.ford.retailstore.service.GroceryItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/editGroceryServlet")
public class EditGroceryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String brand = req.getParameter("brand");
        String manufactureDate = req.getParameter("mfg-date");
        String expiryDate = req.getParameter("exp-date");
        String image = req.getParameter("image");
        int stock = Integer.parseInt(req.getParameter("stock"));

        GroceryItem groceryItem = new GroceryItem(id, name, price, brand, manufactureDate, expiryDate, image, stock);
        int count = AdminUtils.editGroceryItem(groceryItem);
        PrintWriter out = resp.getWriter();
        if (count > 0) {
            out.println("<html><script type='text/javascript'  src='js/edit_grocery_success.js'></script></html>");
        } else {
            out.println("<html><script  type='text/javascript'  src='js/edit_grocery_failure.js'></script></html>");
        }
        out.close();
    }
}
