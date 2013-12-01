<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="user" class="awzurn.User" scope="session"/>
<html>

<head>
<title>Welcome to the eSaint Auction System -- User Portal</title>
</head>

<body>

<center>

<font size="14" color="red">ESAINT AUCTION SYSTEM</font>
<br/>
<br/>

<font size="12">Welcome <%= user.getFirstName() %>!</font>

<form method="link" action="update_profile.jsp">
	<input type="submit" value="Update Profile">
</form>

<form method ="link" action="selling_management.jsp">
	<input type="submit" value="Selling Management">
</form>

<form method ="link" action="bidding_management.jsp">
	<input type="submit" value="Bidding Management">
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