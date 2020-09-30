<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Electronics</title>
    <link rel="stylesheet" href="css/admin_display.css">
</head>
<body>
<a class='add' href='AddElectronics.jsp'>Add Electronics</a>
<a class='add' href='Categories.jsp'>View Categories</a>
<h1>
Electronic Devices
</h1>
<table><tr><th>Product ID</th><th>Name</th><th>Price</th><th>Brand</th><th>Device Type</th><th>Power Rating</th><th>Stock</th><th>Action</th></tr>
<%
for(Electronics electronics:ElectronicsUtils.listAllElectronics())
{
                    out.println("<tr>" +
                            "<td>" + electronics.getId() + "</td>" +
                            "<td>" + electronics.getName() + "</td>" +
                            "<td>" + electronics.getPrice() + "</td>" +
                            "<td>" + electronics.getBrand() + "</td>" +
                            "<td>" + electronics.getDeviceType() + "</td>" +
                            "<td>" + electronics.getPowerRating() + "</td>"+
                             "<td>" + electronics.getStock() + "</td>"+
                            "<td> <a href='EditElectronics.jsp?id="+electronics.getId()+"'>Edit        </a>"+
                            "<a href='/deleteElectronicsServlet?id="+electronics.getId()+"'>Delete</a>"+
                            "</td></tr>");
                }

%>
</table>
</body>
</html>