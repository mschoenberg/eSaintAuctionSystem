<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="user" class="dgwee.eSaint.User" scope="session"/>
<html>

<head>
<title>eSaint Auction System -- Bidding Management</title>
</head>
<body>
<center>

<font size="14" color="red">ESAINT AUCTION SYSTEM</font>
<br/>
<br/>

<font size="12">Bidding Management </font>

<br/>
<br/>
<br/>

<form method="link" action="item_search.jsp">
	<input type="submit" value="Search For Item">
</form>

<form method="link" action="check_status.jsp">
	<input type="submit" value="Check Status">
</form>

<form method="link" action="../user/user_portal.jsp">
	<input type="submit" value="Return to Menu">
</form>

</body>
</html>

