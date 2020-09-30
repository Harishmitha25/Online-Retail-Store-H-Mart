package com.ford.retailstore.controller;

import com.ford.retailstore.service.AdminUtils;
import com.ford.retailstore.service.Electronics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/editElectronicsServlet")
public class EditElectronicsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String brand = req.getParameter("brand");
        String deviceType = req.getParameter("device-type");
        String powerRating = req.getParameter("power-rating");
        String image = req.getParameter("image");
        int stock = Integer.parseInt(req.getParameter("stock"));

        Electronics electronics = new Electronics(id, name, price, brand, deviceType, powerRating, image, stock);
        int count = AdminUtils.editElectronics(electronics);
        PrintWriter out = resp.getWriter();
        if (count > 0) {
            out.println(("<html><script type='text/javascript'  src='js/edit_electronics_success.js'></script></html>"));
        } else {
            out.println(("<html><script  type='text/javascript'  src='js/edit_electronics_failure.js'></script></html>"));
        }
        out.close();
    }
}
