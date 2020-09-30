package com.ford.retailstore.controller;

import com.ford.retailstore.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/orderConfirmation")
public class OrderConfirmationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        double total=0;
        printWriter.println("<html><head><style> "+
                "h1 {" +
                "    color:black;" +
                "    text-align:center;" +
                "    font-family: 'Comic Sans MS', cursive, sans-serif;" +
                "}" +

                "h3 {" +
                "    color:black;" +
                "    text-align:center;" +
                "    font-family: 'Comic Sans MS', cursive, sans-serif;" +
                "}" +

                "table {" +
                "    font-family: 'Comic Sans MS', cursive, sans-serif;" +
                "    border-collapse: collapse;" +
                "    width: 100%;" +
                "}" +


                "table  td, table  th {" +
                "    border: 1px solid #ddd;" +
                "    padding: 5px;" +
                "    background-color:#F0F8FF;" +
                "    color:black ;" +
                "}" +

                "table  th {" +
                "    padding-top: 12px;" +
                "    padding-bottom: 12px;" +
                "    text-align: left;" +
                "    background-color: #ADD8E6;" +
                "    color: black;" +
                "}" +

                ".centre { " +
                "    display:flex;"+
                "}"+

                "a:link, a:visited {" +
                "    background-color:#DCDCDC;" +
                "    color: black;" +
                "    padding:3px;" +
                "    cursor: pointer;" +
                "    width: 10%;" +
                "    font-family:  'Comic Sans MS', cursive, sans-serif;" +
                "    border-radius:5px;" +
                "    text-decoration:none;" +
                "    text-align:center;" +
                "    align-self:center;"+
                "    margin:10px;"+
                "}" +

                "a:hover {" +
                "    opacity:0.8;" +
                "}" +

                "body {" +
                "    font-family: 'Comic Sans MS', cursive, sans-serif;" +
                "}" +

                "input[type=text], input[type=number],.textarea {" +
                "     width: 30%;" +
                "     padding: 12px 20px;" +
                "     margin: 8px 0;" +
                "     display: block;" +
                "     border: 1px solid #ccc;" +
                "     box-sizing: border-box;" +
                "     align-self:center;" +
                "}" +

                "input[type=submit]{" +
                "     background-color:#DCDCDC;" +
                "     color: black;" +
                "     padding:5px;" +
                "     cursor: pointer;" +
                "     width: 10%;" +
                "     font-family: 'Comic Sans MS', cursive, sans-serif;" +
                "     border-radius:5px;" +
                "     text-decoration:none;" +
                "     margin:10px;" +
                "     border:none;" +
                "}" +
                "input[type=number]::-webkit-outer-spin-button,input[type=number]::-webkit-inner-spin-button {\n" +
                "    -webkit-appearance: none;\n" +
                "     margin: 0;\n" +
                "}" +

                "</style>" +

                "<script>" +
                "    function onSubmit() {" +
                "        alert('Details saved');" +
                "}" +
                "</script>" +

                "<body><h1>Order Summary</h1>");
        printWriter.println("<table><th>Name</th><th>Quantity</th><th>Price</th><th>Amount</th>");
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("email");
        for (Product item : CartUtils.getProductsFromCart(userEmail)) {
            total+=item.getQuantity()*item.getPrice();
            printWriter.println(
                    " <tr><td>" + item.getName() + "</td>" +
                    " <td>" + item.getQuantity() + "</td>" +
                    " <td>" + item.getPrice() + "</td>" +
                    " <td>" + item.getQuantity()*item.getPrice() + "</td></tr>");
        }

        String upi="UPI";
        String netBanking="Net Banking";

        printWriter.println("</table><br>");
        printWriter.println("<h3>Total:   "+total+"</h3><br>");
        printWriter.println("<form action='javascript:onSubmit();'>"+
                "<label for='name'><b>Name</b></label><br>" +
                "<input type='text' placeholder='Enter Name' name='name' id='name' required><br>" +

                "<label for='mobile'><b>Mobile</b></label><br>" +
                "<input type='number' placeholder='Enter Mobile Number' name='mobile' id='mobile' required><br>"+

                "<label for='address'><b>Address<b></label><br>"+
                "<textarea id='address' name='address' rows='4' cols='50' required> </textarea>"+

                "  <p>Address Type</p>" +
                "  <input type='radio' id='home' name='address-type' value='Home'>" +
                "  <label for='home'>Home</label><br>" +
                "  <input type='radio' id='female' name='address-type' value='Work'>" +
                "  <label for='work'>Work</label><br>" +
                "  <input type='radio' id='other' name='address-type' value='Others'>" +
                "  <label for='other'>Other</label><br>" +

                "  <input type='submit' name='submit' value='Save'>");

        printWriter.println("<div class='centre'><h3>Payment Options  :  </h3>");
        printWriter.println("<a href='/addOrder?total="+total+"&mode="+upi+"'>UPI </a>");
        printWriter.println("<a  href='/addOrder?total="+total+"&mode="+netBanking+"'>Net Banking</a></div></form>");
        printWriter.println("</body></html>");

        printWriter.close();
    }
}
