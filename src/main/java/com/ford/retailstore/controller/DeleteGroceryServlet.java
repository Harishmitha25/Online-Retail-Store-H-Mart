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

@WebServlet("/deleteGroceryServlet")
public class DeleteGroceryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        GroceryItem employee = new GroceryItem();
        employee.setId(id);
        int count = AdminUtils.deleteGroceryItem(id);
        PrintWriter out = resp.getWriter();

        if (count > 0) {
            out.println("<html><script type='text/javascript'  src='js/delete_grocery_success.js'></script></html>");
        } else {
            out.println("<html><script type='text/javascript'  src='js/delete_grocery_failure.js'></script></html>");
        }
        out.close();
    }
}
