<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<jsp:useBean id="admin" class="dgwee.eSaint.Administrator" scope="session"/> 
<html>
<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title>commission report</title>
</head>
<body>
<%
ResultSet rs = admin.getCommissionReport();
%>
<table
style="text-align: left; height: 139px; margin-right: auto; width: 964px; margin-left: auto;"
border="2" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td colspan="7" rowspan="1"
style="vertical-align: middle; text-align: center;"><big
style="color: red;"><big><big>Commision Report</big></big></big><br>
</td>
</tr>
<tr>
<td style="width: 129px; text-align: center;">User ID<br>
</td>
<td style="text-align: center; width: 241px;">User Name<br>
</td>
<td style="text-align: center;">First Name<br>
</td>
<td style="text-align: center;">Last Name<br>
</td>
<td style="width: 168px; text-align: center;">Email<br>
</td>
<td style="width: 87px; text-align: center;">Seller Rating<br>
</td>
<td style="width: 399px; text-align: center;">Commissions<br>
</td>
</tr>
<%
while(rs.next()){
%>
<tr>
<td style="vertical-align: top; width: 129px;"><input value="<%rs.getString(1);%>" size="7"
readonly="readonly" name="userid"><br>
</td>
<td style="vertical-align: top; width: 241px;"><input value="<%rs.getString(2);%>" size="15"
readonly="readonly" name="username"><br>
</td>
<td style="vertical-align: top;"><input value="<%rs.getString(3);%>" size="15"
readonly="readonly" name="firstname"><br>
</td>
<td style="vertical-align: top;"><input value="<%rs.getString(4);%>" size="15"
readonly="readonly" name="lastname"></td>
<td style="vertical-align: top; width: 168px;"><input value="<%rs.getString(5);%>"
readonly="readonly" name="email"><br>
</td>
<td style="vertical-align: top; width: 87px;"><input value="<%rs.getString(6);%>" size="3"
readonly="readonly" name="sellerrating"><br>
</td>
<td style="vertical-align: top; width: 399px;"><input value="<%rs.getString(7);%>" size="14"
readonly="readonly" name="commission"><br>
</td>
</tr>
<%
}
%>
<tr>
<td colspan="6" rowspan="1"
style="vertical-align: middle; width: 241px; text-align: center;">Total
Commissions:<br>
</td>
<td style="vertical-align: top; width: 399px;"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; width: 241px; text-align: center;"
rowspan="1" colspan="7"><input name="back"
value="Return to Administrator menu" type="submit"></td>
</tr>
</tbody>
</table>
<br>
</body>
</html>

