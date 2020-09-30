<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Grocery Items</title>
    <link rel="stylesheet" href="css/admin_display.css">
</head>
<body>
<a class='add' href='Addgrocery.jsp'>Add Grocery</a>
<a class='add' href='Categories.jsp'>View Categories</a>
<h1>
Grocery Items
</h1>
<table><tr><th>Product ID</th><th>Name</th><th>Price</th><th>Brand</th><th>Manufacture Date</th><th>Best Before</th><th>Stock</th><th>Action</th></tr>
<%
for(GroceryItem item:GroceryUtils.listAllGroceryItems())
{
                    out.println("<tr>" +
                            "<td>" + item.getId() + "</td>" +
                            "<td>" + item.getName() + "</td>" +
                            "<td>" + item.getPrice() + "</td>" +
                            "<td>" + item.getBrand() + "</td>" +
                            "<td>" + item.getManufactureDate() + "</td>" +
                            "<td>" + item.getBestBeforeDate() + "</td>"+
                            "<td>" + item.getStock() + "</td>"+
                            "<td> <a href='EditGrocery.jsp?id="+item.getId()+"'>Edit </a>  "+
                            "<a href='/deleteGroceryServlet?id="+item.getId()+"'>Delete</a>"+
                            "</td></tr>");
                }

%>
</table>
</body>
</html>