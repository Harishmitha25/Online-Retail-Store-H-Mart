<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Books</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
    h1{
      text-align:center;
    }

    body{
      color:black;
      font-family:"Comic Sans MS", cursive, sans-serif;
    }

    div.gallery {
      margin: 5px;
      border: 3px solid #ccc;
      float: left;
      width: 180px;
    }

    div.gallery:hover {
      border: 1px solid #777;
    }

    div.gallery img {
      width: 100%;
      height: 150px;
    }

    div.desc {
      padding: 15px;
      text-align: center;
      height:70px;
    }

    .helper{
      float:right;
      padding:5px;
      color:black;
    }

    .helper:hover{
       color:#4682B4;
       text-decoration:none;
    }

    </style>

</head>
<body>
<a class='helper' href='/UserPage.jsp'><span class="glyphicon glyphicon-home"></span>HomePage</a>
<h1>
Books
</h1>
<%
for(Book book:BookUtils.listAllBooks())
{
if(book.getStock()>1){
out.println("<div class='gallery'><a href='/BookDetails.jsp?id="+book.getId()+"'><img src='"+book.getImage()+"' alt='"+book.getName()+"' width='200' height='200'></a><div class='desc'>"+book.getName()+"</div></div>");
}
}
%>
</body>
</html>