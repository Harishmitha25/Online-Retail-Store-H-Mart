<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Electronics</title>
    <link rel="stylesheet" href="css/admin_operation.css">
</head>
<body>
<h1>
Edit Electronic Device
</h1>
<%
String id= request.getParameter("id");
Electronics electronics=ElectronicsUtils.getElectronicsDetails(id);
 out.println("<form action='/editElectronicsServlet' method='get'>"+
 "<div class='container'>"+
 "<div class='container-one'>"+
    "<label for='id'>Product ID"+ "<input type='text' name='id' id='id' value='"+electronics.getId()+"'></label>"+
    "<label for='name'>Name "+ "<input type='text' name='name' id='name' value='"+electronics.getName()+"'></label>"+
    "<label for='price'>Price "+"<input type='number' name='price' id='price' value='"+electronics.getPrice()+"'></label>"+
    "<label for='brand'>Brand "+ "<input type='text' name='brand' id='brand' value='"+electronics.getBrand()+"' ></label>"+
    "</div>"+
 "<div class='container-two'>"+
    "<label for='device-type'>Device Type"+ "<input type='text' name='device-type' id='device-type' value='"+electronics.getDeviceType()+"'></label>"+
    "<label for='power-rating'>Power Rating "+ "<input type='text' name='power-rating' id='power-rating' value='"+electronics.getPowerRating()+"'></label>"+
    "<label for='image'>Image url "+"<input type='text' name='image' id='image' value='"+electronics.getImage()+"'></label>"+
    "<label for='stock'>Stock value "+ "<input type='number' name='stock' id='stock' value='"+electronics.getStock()+"' ></label>"+
    "</div></div>"+
    "<div class='button'>"+
 "<input type='submit' name='button' value='Update'>" +"</div></form></body></html>");
%>
</body>
</html>