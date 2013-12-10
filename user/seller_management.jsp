<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="user" class="dgwee.eSaint.User" scope="session"/>

<html>
<head>

<title>Seller Management</title>
</head>
<body>

<div style="text-align: center;">Seller Management</div>

<form method="link" action="Item List.jsp">
	<input name="List Items" value="List Items" type="button">
</form>


<form method="link" action="Add Item.jsp">
        <input name="Add Item" value="Add Item" type="submit"><br>
</form>


<form method="link" action="User Management.jsp">
        <input name="Return to Menu" value="Return to Menu" type="submit"><br>
</form>


</body></html>
