<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Books</title>
    <link rel="stylesheet" href="css/admin_display.css">
</head>
<body>
<a class='add' href='AddBook.jsp'>Add Book</a>
<a class='add' href='Categories.jsp'>View Categories</a>
<h1>
Books
</h1>
<table><tr><th>Product ID</th><th>Name</th><th>Price</th><th>Brand</th><th>Author Name</th><th>Genre</th><th>Stock</th><th>Action</th></tr>
<%
for(Book book:BookUtils.listAllBooks())
{
                    out.println("<tr>" +
                            "<td>" + book.getId() + "</td>" +
                            "<td>" + book.getName() + "</td>" +
                            "<td>" + book.getPrice() + "</td>" +
                            "<td>" + book.getBrand() + "</td>" +
                            "<td>" + book.getAuthorName() + "</td>" +
                            "<td>" + book.getGenre() + "</td>"+
                             "<td>" + book.getStock() + "</td>"+
                            "<td> <a href='EditBook.jsp?id="+book.getId()+"'>Edit       </a>"+
                            "<a href='/deleteBookServlet?id="+book.getId()+"'>Delete</a>"+
                            "</td></tr>");
                }

%>
</table>
</body>
</html>