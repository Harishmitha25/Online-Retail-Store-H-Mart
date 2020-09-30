<%@ page import="com.ford.retailstore.*"%>

<html lang="en">
<head>
    <title>Invalid Credentials</title>
<%
String message=AdminLoginFailedException.invalidCredentials();
out.println("<html><script id='message' type='text/javascript' data-message='"+message+"' src='js/admin_login_fail.js'></script></html>");
%>
</body>
</html>