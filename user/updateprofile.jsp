<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="user" class="dgwee.eSaint.User" scope="session"/>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title>Update Profile</title>
</head>
<body>
<form method="post" action="updateprofileaction.jsp" name="update">
<table
style="text-align: left; width: 514px; height: 795px; margin-left: auto; margin-right: auto;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td colspan="3" rowspan="1"
style="vertical-align: middle; text-align: center; width: 378px;"><span
style="color: red;">Update Your Profile</span><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Username:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: middle; text-align: center; width: 378px;"><input
name="username" value="<%out.println(user.getUsername());%>"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">First Name:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: middle; text-align: center; width: 378px;"><input
name="firstName" value="<%out.println(user.getFirstName());%>"></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Last Name:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: top; width: 378px; text-align: center;"><input
name="lastName" value="<%out.println(user.getLastName());%>"></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Email:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: top; width: 378px; text-align: center;"><input
name="email" value="<%out.println(user.getEmail());%>"></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Phone:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: top; width: 378px; text-align: center;"><input
name="phoneNum" value="<%out.println(user.getPhoneNum());%>"></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Credit Card Number:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: top; width: 378px; text-align: center;"><input
name="cardNum" value="<%out.println(user.getCardNum());%>"></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Expiration date:<br>
</td>
<td style="vertical-align: top; width: 378px; text-align: center;"><input
size="10" name="cardExpMonth" value="<%out.println(user.getCardExpMonth());%>"></td>
<td style="vertical-align: top; text-align: center;"><input
size="10" name="cardExpYear" value="<%out.println(user.getCardExpYear());%>"></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Card Type:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: top; width: 378px; text-align: center;"><input
name="cardType" value="<%out.println(user.getCardType());%>"></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Buyer Rating:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: top; width: 378px; text-align: center;"><input
readonly="readonly" name="brate" value="uname"></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Number of Buyer
Ratings:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: top; width: 378px; text-align: center;"><input
readonly="readonly" name="nbrate" value="uname"></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Seller Rating:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: top; width: 378px; text-align: center;"><input
readonly="readonly" name="srate" value="uname"></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Number of Seller
Ratings:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: top; width: 378px; text-align: center;"><input
readonly="readonly" name="nsrate" value="uname"></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Old Password:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: top; width: 378px; text-align: center;"><input
name="opass" value=""></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">New Password:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: top; width: 378px; text-align: center;"><input
name="password" value="New Password"></td>
</tr>
<tr>
<td style="vertical-align: top; width: 116px;">Retype Password:<br>
</td>
<td colspan="2" rowspan="1"
style="vertical-align: top; width: 378px; text-align: center;"><input
name="password2" value="Retype New Password"></td>
</tr>

</tbody>
</table>
	<input name="update" value="update" type="submit">
</form>
<form method ="link" action="user_portal.jsp">
	<input type="submit" value="Cancel">
</form>

<br>
</body>
</html>


