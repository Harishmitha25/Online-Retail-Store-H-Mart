<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Book</title>
   <link rel="stylesheet" href="css/admin_operation.css">
</head>
<body>
<h1>
Edit Book
</h1>

<%
String id= request.getParameter("id");
Book book=BookUtils.getBookDetails(id);
 out.println("<form action='/editBookServlet' method='get'>"+
 "<div class='container'>"+
 "<div class='container-one'>"+
    "<label for='id'>Product ID"+ "<input type='text' name='id' id='id' value='"+book.getId()+"'></label>"+
    "<label for='name'>Name "+ "<input type='text' name='name' id='name' value='"+book.getName()+"'></label>"+
    "<label for='price'>Price "+"<input type='number' name='price' id='price' value='"+book.getPrice()+"'></label>"+
    "<label for='brand'>Brand "+ "<input type='text' name='brand' id='brand' value='"+book.getBrand()+"' ></label>"+
    "</div>"+

 "<div class='container-two'>"+
    "<label for='author-name'>Author Name"+ "<input type='text' name='author-name' id='author-name' value='"+book.getAuthorName()+"'></label>"+
    "<label for='genre'>Genre "+ "<input type='text' name='genre' id='genre' value='"+book.getGenre()+"'></label>"+
    "<label for='image'>Image url "+"<input type='text' name='image' id='image' value='"+book.getImage()+"'></label>"+
    "<label for='stock'>Stock value "+ "<input type='number' name='stock' id='stock' value='"+book.getStock()+"' ></label>"+
    "</div></div>"+
    "<div class='button'>"+
 "<input type='submit' name='button' value='Update'>" +"</div></form></body></html>");
%>
</body>
</html>