<%@ page import="com.ford.retailstore.service.*"%>
<%@ page import="com.ford.retailstore.model.*"%>
<%@ page import="com.ford.retailstore.controller.*"%>
<%@ page import ="java.util.*"%>
<html lang="en">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
       h3 {
          text-align:center;
          color:#000080;
          font-family:"Comic Sans MS", cursive, sans-serif;
          padding:10px;
       }

       .navbar {
          margin-bottom: 50px;
          padding:none;
          border:none;
          background-color:white;
       }

       .jumbotron {
          margin-bottom: 0;
          font-family:"Comic Sans MS", cursive, sans-serif;border:none;
          color:#000080;
          background-color:white;
       }

       .navbar-inverse .navbar-nav>li>a {
          color:#000080;
          font-family:"Comic Sans MS", cursive, sans-serif;border:none;
       }

       .navbar-inverse .navbar-nav>li>a:hover {
          background-color:#4682B4;
       }

       .carousel-container {
          margin:30px;
       }

       ul {
          font-size:20px;
       }

       .container-fluid {
          background-color:#F0F8FF;
       }

       .panel-primary {
          border:none;
       }

       .container {
          border-top:1px solid #D3D3D3;
          border-bottom:1px solid #D3D3D3;
       }
      .dropdown {
          float: left;
          overflow: hidden;
       }
    </style>
</head>
<body>
<div class="jumbotron">
    <div class=" text-center">
        <h1>Welcome to H Mart</h1>
    </div>
</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div style="background-color:white;" class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="Categories.jsp"><span class="glyphicon glyphicon-th-large"></span> View Product Categories</a></li>
                <li><a href="Report.jsp"><span class="glyphicon glyphicon-download"></span> Download Report</a></li>
            </ul>
          <ul class="nav navbar-nav navbar-right">
                <li><a href="OrderDetails.jsp"><span class="glyphicon glyphicon-ok-circle"></span> View Order Details</a></li>
                <li><a href="PaymentDetails.jsp"><span class="glyphicon fa fa-rupee"></span> View Payment Details</a></li>
                <li><a href="/adminLogoutServlet"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
          </ul>
        </div>
    </div>
</nav>
<div class="carousel-container">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <div class="carousel-inner">
            <div class="item active">
                <img src="images/grocery1.jpg" alt="vegetables" style="width:100%;height:600px">
            </div>

            <div class="item">
                <img src="images/grocery2.jpg" alt="grocery" style="width:100%;height:600px">
            </div>

            <div class="item">
                <img src="images/grocery3.jpg" alt="fruits" style="width:100%;height:600px">
            </div>

            <div class="item">
                <img src="images/book_store.jpg" alt="book_store" style="width:100%;height:600px">
            </div>
            <div class="item">
                <img src="images/electronics.jpg" alt="electronics" style="width:100%;height:600px">
            </div>

        </div>
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<%

%>
</body>
</html>