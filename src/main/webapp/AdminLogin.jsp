<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<h1>
Admin Login
</h1>
<form action="/adminLoginServlet" method="post">
  <div class='container'>

    <label for='username'><b>Username</b></label>
    <input type='text' placeholder='Enter Username' name='username' id='username' required>

    <label for='password'><b>Password</b></label>
    <input type='password' placeholder='Enter Password' name='password' id='password' required>
    <button type='submit'>Login</button>
  </div></form>
<%
%>
</body>
</html>