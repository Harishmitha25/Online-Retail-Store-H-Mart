<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Grocery</title>
    <link rel="stylesheet" href="css/admin_operation.css">
</head>
<body>
<h1>
Edit Grocery
</h1>

<%
String id= request.getParameter("id");
GroceryItem item=GroceryUtils.getGroceryDetails(id);
 out.println("<form action='/editGroceryServlet' method='get'>"+
 "<div class='container'>"+
 "<div class='container-one'>"+
    "<label for='id'>Product ID"+ "<input type='text' name='id' id='id' value='"+item.getId()+"'></label>"+
    "<label for='name'>Name "+ "<input type='text' name='name' id='name' value='"+item.getName()+"'></label>"+
    "<label for='price'>Price "+"<input type='number' name='price' id='price' value='"+item.getPrice()+"'></label>"+
    "<label for='brand'>Brand "+ "<input type='text' name='brand' id='brand' value='"+item.getBrand()+"' ></label>"+
    "</div>"+
 "<div class='container-two'>"+
    "<label for='mfg-date'>Manufacture Date"+ "<input type='text' name='mfg-date' id='mfg-date' value='"+item.getManufactureDate()+"'></label>"+
    "<label for='exp-date'>Expiry Date "+ "<input type='text' name='exp-date' id='exp-date' value='"+item.getBestBeforeDate()+"'></label>"+
    "<label for='image'>Image url "+"<input type='text' name='image' id='image' value='"+item.getImage()+"'></label>"+
    "<label for='stock'>Stock value "+ "<input type='number' name='stock' id='stock' value='"+item.getStock()+"' ></label>"+
    "</div></div>"+
    "<div class='button'>"+
 "<input type='submit' name='button' value='Update'>" +"</div></form></body></html>");
%>
</body>
</html>