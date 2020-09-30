package com.ford.retailstore.controller;

import com.ford.retailstore.service.AdminUtils;
import com.ford.retailstore.service.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String brand = req.getParameter("brand");
        String authorName = req.getParameter("author-name");
        String genre = req.getParameter("genre");
        String image = req.getParameter("image");
        int stock = Integer.parseInt(req.getParameter("stock"));

        Book book = new Book(id, name, price, brand, authorName, genre, image, stock);
        int count = AdminUtils.addBook(book);

        PrintWriter out = resp.getWriter();
        if (count > 0) {
            out.println(("<html><script type='text/javascript' src='js/add_book_success.js'></script></html>"));
        } else {
            out.println(("<html><script type='text/javascript' src='js/add_book_failure.js'></script></html>"));
        }
        out.close();
    }
}
