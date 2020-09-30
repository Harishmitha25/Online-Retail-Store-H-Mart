<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
    <link rel="stylesheet" href="css/admin_operation.css">
</head>
<body>
<h1>
Add Book
</h1>
<form action="/addBookServlet" method="get">
<div class="container">
<div class="container-one">
    <label for="id" class="label">Product ID
        <input type="text" name="id" id="id"></label>
    <label for="name" class="label">Name
        <input type="text" name="name" id="name"></label>
    <label for="price" class="label">Price
        <input type="number" name="price" id="price"></label>
    <label for="brand" class="label">Brand
         <input type="text" name="brand" id="brand"></label></div>
    <div class="container-two">
    <label for="author-name" class="label">Author Name
         <input type="text" name="author-name" id="author-name"></label>
    <label for="genre" class="label">Genre
         <input type="text" name="genre" id="genre"></label>
    <label for="image" class="label">Image url
              <input type="text" name="image" id="image"></label>
    <label for="stock" class="label">Stock value
          <input type="number" name="stock" id="stock"></label>
    </div></div>
    <div class="button">
    <input type="submit" name="button" value="Add"></div></form>
<%

%>
</body>
</html>