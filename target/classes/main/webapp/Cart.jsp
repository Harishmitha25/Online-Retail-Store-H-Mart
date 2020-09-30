<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<%@ page import="com.ford.retailstore.controller.*"%>
<%@ page import ="java.util.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
    <link rel="stylesheet" href="css/cart.css">
</head>
<body>
<a class='top' href='/userLogoutServlet'>Logout</a>
<a class='top' href='/emptyCart'>Empty Cart</a></body></html>
<a class='top' href='/orderConfirmation'>Place Order</a>
<a class='top' href='UserPage.jsp'>Add more products to cart</a>
<h1>
Cart
</h1>
<br>
<%
String userEmail = (String) session.getAttribute("email");
List<Product> productList=CartUtils.getProductsFromCart(userEmail);
if(productList.isEmpty()){
out.println("<html><script type='text/javascript' src='js/cart_is_empty.js'></script></html>");
}
else{
for(Product item: productList){
            out.println("<html><body><div class='container' ><img src='"+item.getImage()+"' alt='"+item.getName()+"' width='160' height='160'>" +
                     "<div>Product ID : "+item.getId()+"</div>"+
                     "<div>Name        : "+item.getName()+"</div>"+
                     "<div>Price       : "+item.getPrice()+"</div>"+
                     "<div>Brand       : "+item.getBrand()+"</div>"+
                     "<div>Required Quantity: "+item.getQuantity()+"<br><br></div><a class='button' href='deleteProductFromCart?id="+item.getId()+"'>Remove Product</a>");
                     if(item.getId().startsWith("G")){
                     out.println("<a href='UpdateGroceryQuantity.jsp?id="+item.getId()+"'>Update Quantity</a><br>");
                     }
                     else if(item.getId().startsWith("B")){
                     out.println("<a href='UpdateBookQuantity.jsp?id="+item.getId()+"'>Update Quantity</a><br>");
                     }
                     else if(item.getId().startsWith("E")){
                     out.println("<a href='UpdateElectronicsQuantity.jsp?id="+item.getId()+"'>Update Quantity</a><br>");
                     }
                     out.println("</div>");
                     }
            }
%>
</body>
</html>