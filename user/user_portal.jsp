<%@ page language="java" import="java.sql.*"%>

<jsp:useBean id="user" class="dgwee.eSaint.User" scope="session"/>
<html>

<head>
<title>Welcome to the eSaint Auction System -- User Portal</title>
</head>

<body>

<center>

<font size="14" color="red">ESAINT AUCTION SYSTEM</font>
<br/>
<br/>

<font size="12">Welcome <%= user.getUsername() %>!</font>

<form method="link" action="updateprofile.jsp">
	<input type="submit" value="Update Profile">
</form>

<form method ="link" action="selling_management.jsp">
	<input type="submit" value="Selling Management">
</form>

< HEAD>
<form method ="link" action="../Bidding_Management/bidding_management.jsp">
	<input type="submit" value="Bidding Management">

<form method ="link" action="itemsBidOn.jsp">
	<input type="submit" value="Current Bids">
</form>
<form method ="link" action="leave_feedback.jsp">
	<input type="submit" value="Leave Feedback">
</form>

<form method ="get" action="logout_action.jsp?type=2">
	<input type="submit" value="Logout">
</form>

</center>
</body>
</html>
