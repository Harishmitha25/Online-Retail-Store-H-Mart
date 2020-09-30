<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<%@ page import="com.ford.retailstore.controller.*"%>
<%@ page import ="java.util.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Books</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
         h1{
             text-align:center;
             color:black;
             padding:30px;
         }

         body{
             font-family:"Comic Sans MS", cursive, sans-serif;
             color:black;
         }

         img{
             float:left;
             margin-right:15px;
         }

         .helper{
            float:right;
            text-decoration:none;
            padding:5px;
            color:black;
            font-size:18px;
            font-family:"Comic Sans MS", cursive, sans-serif;
         }

         .helper:hover{
            opacity:0.8;
         }

         .centre{
             width:50%;
             margin: auto;
             font-size:18px;
         }

         .label{
             color:black;
             font-size:18px;
             font-weight:normal;
             margin:-10px;
         }

         input[type=number]{
            width:5%;
         }

         input[type=submit]{
             background-color: #DCDCDC;
             color: black;
             cursor: pointer;
             width: 10%;
             margin-left:20px;
             border:none;
             border-radius:5px;
             padding:5px;
         }

         input[type=submit]:hover{
             opacity:0.7;
         }
    </style>
</head>
<body>
<a class='helper' href='/UserPage.jsp'><span class="glyphicon glyphicon-home">HomePage</a><br>
<h1>
Book Detail
</h1>
<%
String id=request.getParameter("id");
Book book=BookUtils.getBookDetails(id);
            out.println("<html><body><div class='centre'><img src='"+book.getImage()+"' alt='"+book.getName()+"' width='200' height='200'>" +
                      "<div>Product ID :  "+book.getId()+"</div>"+
                     "<div>Name        : "+book.getName()+"</div>"+
                     "<div>Price       : "+book.getPrice()+"</div>"+
                     "<div>Brand       : "+book.getBrand()+"</div>"+
                     "<div>Author Name : "+book.getAuthorName()+"</div>"+
                     "<div>Genre       :"+book.getGenre()+"</div></div>"+
                     "<form action='/stockCheck' method='get'>"+
                                          "<label for='quantity' class='label'>Quantity  "+
                                          "<input type='number' name='quantity' id='quantity' value='1' min='1'></label>"+
                                          "<label for='id' class='label'>"+
                                          "<input type='hidden' name='id' id='id' value='"+book.getId()+"'></label>"+
                                          "<input type='submit' name='submit' value='Add to Cart'>"+
                     "</body></html>");
%>
</body>
</html>