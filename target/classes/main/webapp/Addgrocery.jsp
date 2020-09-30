<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Grocery</title>
    <link rel="stylesheet" href="css/admin_operation.css">
</head>
<body>
<h1>
Add Grocery
</h1>

<form action="/addGroceryServlet" method="get">
<div class="container">
<div class="container-one">
    <label for="id" class="label">Product ID
        <input type="text" name="id" id="id" required></label>
    <label for="name" class="label">Name
        <input type="text" name="name" id="name" required></label>
    <label for="price" class="label">Price
        <input type="number" name="price" id="price" required></label>
    <label for="brand" class="label">Brand
         <input type="text" name="brand" id="brand" required></label>
         </div>
    <div class="container-two">

    <label for="mfg-date" class="label">Manufacture Date
         <input type="text" name="mfg-date" id="mfg-date" required></label>
    <label for="exp-date" class="label">Expiry Date
         <input type="text" name="exp-date" id="exp-date" required></label>
    <label for="image" class="label">Image url
              <input type="text" name="image" id="image" required></label>
    <label for="stock" class="label">Stock value
          <input type="number" name="stock" id="stock" required></label></div></div>
          <div class="button">
    <input type="submit" name="button" value="Add"></div>
    </form>
<%

%>
</body>
</html>