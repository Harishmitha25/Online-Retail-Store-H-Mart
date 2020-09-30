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

@WebServlet("/deleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Book book = new Book();
        book.setId(id);
        int count = AdminUtils.deleteBook(id);
        PrintWriter out = response.getWriter();
        if (count > 0) {
            out.println(("<html><script type='text/javascript'  src='js/delete_book_success.js'></script></html>"));
        } else {
            out.println(("<html><script type='text/javascript'  src='js/delete_book_failure.js'></script></html>"));
        }
        out.close();
    }
}

