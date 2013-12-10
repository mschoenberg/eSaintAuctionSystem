<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<jsp:useBean id="user" class="dgwee.eSaint.User" scope="session"/>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title>Items Bid On</title>
</head>
<body>
<table
style="text-align: left; width: 905px; height: 144px; margin-left: auto; margin-right: auto;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td colspan="8" rowspan="1"
style="vertical-align: middle; text-align: center;"><span
style="color: red;">List of Items Bid On</span><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Item Id<br>
</td>
<td style="vertical-align: top;">Item Name<br>
</td>
<td style="vertical-align: top;">Catergory<br>
</td>
<td style="vertical-align: top;">Auction Start Time<br>
</td>
<td style="vertical-align: top;">Auction End TIme<br>
</td>
<td style="vertical-align: top;">Start Price<br>
</td>
<td style="vertical-align: top;"><br>
</td>
<td style="vertical-align: top;"><br>
</td>
</tr>
<%
ResultSet rs = user.getItemsSold();
While(rs.next()){
%>
<tr>
<td style="vertical-align: top;"><%= rs.getString(1);%><br>
</td>
<td style="vertical-align: top;"><%= rs.getString(2);%><br>
</td>
<td style="vertical-align: top;"><%= rs.getString(3);%><br>
</td>
<td style="vertical-align: top;"><%= rs.getString(4);%><br>
</td>
<td style="vertical-align: top;"><%= rs.getString(5);%><br>
</td>
<td style="vertical-align: top;"><%= rs.getString(6);%><br>
</td>
<td style="vertical-align: top;"><br>
</td>
<td style="vertical-align: top;"><br>
</td>
</tr>
<%
}
%>
<tr>
<td colspan="8" rowspan="1"
style="vertical-align: top; text-align: center;"><a
href="file:///home/f10/mvschoenberg/java-docs/user/user_portal.jsp">Return
to Man Page</a><br>
</td>
</tr>
</tbody>
</table>
<br>
</body>
</html>


