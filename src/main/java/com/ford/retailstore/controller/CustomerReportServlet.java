package com.ford.retailstore.controller;

import com.ford.retailstore.service.User;
import com.ford.retailstore.service.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/customerReport")
public class CustomerReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        List<User> userList = UserUtils.getUsers();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter("C:\\ford\\OnlineRetailStore\\src\\main\\java\\com\\ford\\retailstore\\Customer Report.csv");
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("User Name,User Email,User Mobile");
            for (User user : userList) {
                printWriter.println(user.getUserName() + "," + user.getEmail() + "," + user.getMobileNumber());
            }
            out.println("<html><head><script type='text/javascript' src='js/download_customer_details.js'></script></head></html>");
        } catch (IOException e) {
            System.out.println("Error occurred while downloading customer report");
        } finally {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        }
    }
}
