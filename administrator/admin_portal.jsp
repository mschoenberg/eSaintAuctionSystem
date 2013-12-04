<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="admin" class="dgwee.eSaint.Administrator" scope="session"/>
<html>

<head>
<title>Welcome to the eSaint Auction System -- Admin Portal</title>
</head>

<body>

<center>

<font size="14" color="red">eSaint Admin Portal</font>
<br/>
<br/>

<font size="12">Welcome <%= admin.getUsername() %>!</font>

<form method="link" action="user_management.jsp">
	<input type="submit" value="User Management">
</form>

<form method ="link" action="reports.jsp">
	<input type="submit" value="Reports">
</form>

<form method ="get" action="logout_action.jsp?type=1">
	<input type="submit" value="Logout">
</form>

</center>
</body>
</html>