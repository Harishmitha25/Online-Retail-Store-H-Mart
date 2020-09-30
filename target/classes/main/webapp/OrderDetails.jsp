<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<%@ page import="com.ford.retailstore.controller.*"%>
<%@ page import ="java.util.*"%>
<html lang="en">
<head>
    <title>Order Details</title>
   <link rel="stylesheet" href="css/order_details.css">
    </style>
</head>
<body>
<h1>
Order Details
</h1>
<table><tr><th>Order ID</th><th>User Email</th><th>User Mobile</th><th>User Name</th><th>Product ID</th><th>Product Name</th><th>Price</th><th>Quantity</th><th>Action</th></tr>
<%
                for (Order order : OrderUtils.getOrders()) {
                    out.println("<tr>" +
                            "<td>" + order.getOrderId() + "</td>" +
                            "<td>" + order.getUserEmail() + "</td>" +
                            "<td>" + order.getUserMobile() + "</td>" +
                            "<td>" + order.getUserName() + "</td>" +
                            "<td>" + order.getProductId() + "</td>" +
                            "<td>" + order.getProductName() + "</td>" +
                            "<td>" + order.getProductPrice() + "</td>" +
                            "<td>" + order.getProductQuantity() + "</td>"+
                            "<td><a href='/productAvailabilityCheck?orderId="+order.getOrderId()+"&productId="+order.getProductId()+"'>Check availability to delete</a></td></tr>");
                }
%>
</table>
</body>
</html>