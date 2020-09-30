package com.ford.retailstore.controller;

import com.ford.retailstore.service.CartUtils;
import com.ford.retailstore.service.User;
import com.ford.retailstore.service.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobile");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(email, Long.parseLong(mobileNumber), userName, password);
        int count = UserUtils.addUser(user);
        if (count > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("mobile", mobileNumber);
            session.setAttribute("userName", password);
            session.setAttribute("loginCheck", "true");
            CartUtils.emptyCart(email);
            printWriter.println("<html><script id='signin' data-signin='" + count + "' type='text/javascript' src='js/signin_message.js'></script></html>");
        } else {
            printWriter.println("<html><script id='signin' data-signin='" + count + "'type='text/javascript' src='js/signin_message.js'></script></html>");
        }
        printWriter.close();
    }
}
