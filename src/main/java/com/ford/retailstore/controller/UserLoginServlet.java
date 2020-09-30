package com.ford.retailstore.controller;

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

import java.util.List;

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        List<User> userList = UserUtils.getUsers();

        for (User userRef : userList) {
            if ((userRef.getUserName().equals(userName)) && (userRef.getPassword().equals(password))) {
                HttpSession session = request.getSession();
                session.setAttribute("email", userRef.getEmail());
                session.setAttribute("mobile", userRef.getMobileNumber());
                session.setAttribute("userName", userRef.getUserName());
                session.setAttribute("loginCheck", "true");
                printWriter.println("<html><script type='text/javascript' src='js/login_success_message.js'></script></html>");
                return;
            }
        }
        printWriter.println("<html><script type='text/javascript' src='js/login_failure_message.js'></script></html>");
        printWriter.close();
    }
}
