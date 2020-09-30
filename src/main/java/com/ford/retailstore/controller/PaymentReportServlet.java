package com.ford.retailstore.controller;

import com.ford.retailstore.service.Payment;
import com.ford.retailstore.service.PaymentUtils;

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

@WebServlet("/paymentReport")
public class PaymentReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        List<Payment> paymentList = PaymentUtils.getPaymentDetails();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter("C:\\ford\\OnlineRetailStore\\src\\main\\java\\com\\ford\\retailstore\\Payment Report.csv");
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("Order ID,User Email,User Mobile,User Name,Total,Payment Mode");
            for (Payment payment : paymentList) {
                printWriter.println(payment.getOrderId() + "," + payment.getUserEmail() + "," + payment.getUserMobile() + "," + payment.getUserName() + "," + payment.getTotal() + "," + payment.getPaymentMode());
            }
            out.println("<html><head><script type='text/javascript' src='js/download_payment.js'></script></head></html>");
        } catch (IOException e) {
            System.out.println("Error occurred while downloading payment report");
        } finally {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        }
    }
}
