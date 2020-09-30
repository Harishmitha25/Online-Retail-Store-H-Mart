<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Signin</title>
    <style>
    h1{
       text-align:center;
       color:#000080;
    }
    body {
       font-family: "Comic Sans MS", cursive, sans-serif;
    }
    input[type=text], input[type=password], input[type=email],input[type=number] {
       width: 50%;
       padding: 12px 20px;
       margin: 8px 0;
       display: block;
       border: 1px solid #ccc;
       box-sizing: border-box;
       align-self:center;
    }
    input[type=number]::-webkit-outer-spin-button,input[type=number]::-webkit-inner-spin-button {
        -webkit-appearance: none;
         margin: 0;
    }
    button {
       background-color: #000080;
       color: white;
       padding: 14px 20px;
       margin: 8px 0;
       cursor: pointer;
       width: 10%;
       align-self:center;
    }
    button:hover {
       opacity: 0.8;
    }
    .container{
       display:flex;
       flex-direction: column;
    }
    label {
       align-self:center;
    }
    </style>
</head>
<body>
<h1>
User Signup
</h1>
<form action="/userRegistrationServlet" method="post">
  <div class='container'>
    <label for='email'><b>Email</b></label>
    <input type='email' placeholder='Enter Email' name='email' id='email' size='30' required>

    <label for='mobile'><b>Mobile Number</b></label>
    <input type='number' placeholder='Enter Mobile Number' name='mobile' id='mobile' required>

    <label for='username'><b>Username</b></label>
    <input type='text' placeholder='Enter Username' name='username' id='username' required>

    <label for='password'><b>Password</b></label>
    <input type='password' placeholder='Enter Password' name='password' id='password' required>
    <button type='submit'>Register</button>
  </div></form>
<%

%>
</body>
</html>