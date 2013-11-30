<%@ page language="java"%>
<%@ page import="java.util.*"%>

<html>

<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title>Login -- eSaint Auction System -- One Hit Wonders</title>
</head>

<body>
<center>
<font size="14" color="red">ESAINT AUCTION SYSTEM</font>
<br/>
<br/>

<%
  int errorNum = request.getParameter("error");
  if( errorNum == -1 ){
    out.println("<font color="red" size="12">An error occured, please try again!</font><br/><br/>");
  }
%>

Please enter the Following:
<br/>
<br/>
<form method="post" action="login_action.jsp" name="Login">
Username:&nbsp;<input name="username" value="">
<br/>
Password:&nbsp;<input name="password" type="password" value="">
<br/>
<input type="radio" name="userType" value="admin">Admin
<input type="radio" name="userType" value="user">User
<br/>
<input name="Login" value="Login" type="submit">&nbsp;&nbsp;&nbsp; <input
type="reset"><br>
</form>
</center>
</body>
</html>

