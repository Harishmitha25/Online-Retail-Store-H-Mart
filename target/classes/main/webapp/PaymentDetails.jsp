<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<%@ page import="com.ford.retailstore.controller.*"%>
<%@ page import ="java.util.*"%>
<html lang="en">
<head>
    <title>Order Details</title>
    <link rel="stylesheet" href="css/payment_details.css">
</head>
<body>
<h1>Payment Details</h1>
<table style="width:100%"><tr><th>Order ID</th><th>User Email</th><th>User Mobile</th><th>User Name</th><th>Amount Paid</th><th>Payment Mode</th></tr>
<%
            for (Payment payment : PaymentUtils.getPaymentDetails()) {
                    out.println("<tr>" +
                            "<td>" + payment.getOrderId() + "</td>" +
                            "<td>" + payment.getUserEmail() + "</td>" +
                            "<td>" + payment.getUserMobile() + "</td>" +
                            "<td>" + payment.getUserName() + "</td>" +
                            "<td>" + payment.getTotal() + "</td>" +
                            "<td>" + payment.getPaymentMode() + "</td>" +
                            "</tr>");
            }
%>
</table>
</body>
</html>