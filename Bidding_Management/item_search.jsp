<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="user" class="dgwee.eSaint.User" scope="session"/>
<html>
<head>
<title>
eSaint Auction System -- Item Search
</title>

</head>
<body>
<center>
<font size="14" color="red">ESAINT AUCTION SYSTEM</font>
<br/>
<br/>

<font size="12">Item Search </font>
<form method="POST" action="item_search_action.jsp">
<table>
	<tr>
		<td>Item ID<td>
		<td><input name="item_id" value=-1 ></td><br>
	
	</tr>
	<tr>
		<td>Keyword<td>
		<td><input name="keyword" value="" ></td><br>
	<tr/>
	<tr>
		<td>Category<td>
		<td><select name="category_list">
		<option value = "Select">--Select--</option>
			<%
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection myConnection = DriverManager.getConnection("jdbc:mysql://devsrv.cs.csbsju.edu:3306/OneHitWonders", "DWee", "DWee");
			        Statement stmt=myConnection.createStatement();
       		          	String queryString = "Select CATEGORY from ITEM;";
       				ResultSet rs = stmt.executeQuery(queryString);
        			while(rs.next()){
          				 String s = rs.getString("CATEGORY");
			%>
			<option value= "<%=s %>"><%= s%></option> 
			<%
           			}
				
   			 } catch (Exception E) {
            			E.printStackTrace();
    			}
%> 
		</select><td>
	</tr>
	<tr>
		<td>Bid Range<td>
		<td>
			<table>
				<tr>		
					<td>Min:<td>
					<td><input name="min_bid" value= 0.00 size=10><td>
				</tr>
				<tr>
					<td>Max:<td>
					<td><input name="max_bid" value = 0.00 size=10><td>
				</tr>
			</table>
		<td>
		
	</tr>
	<tr>
		<td>Auction Time<td>
		<td>
			<table>
				<tr>
					<td>Start<td>
					<td><select name = "start_day">
					<option name = acutionStart_day>0</option>
						<%
							for(int i = 1; i<32; i++){
						%>
							<option name= "<%= i %>"><%= i%></option>
						<%
							}
						%>
					</select>
					<td>
					<td>
					<td><select name = "start_month">
					<option name = acutionStart_month>0</option>
						<%
							for(int i = 1; i<13; i++){
						%>
							<option name= "<%= i %>"><%= i%></option>
						<%
							}
						%>
					</select>
					<td>
					<td>
					<td><select name = "start_year">
					<option name = acutionStart_year>0</option>
						<%
							for(int i = 2000; i<2014; i++){
						%>
							<option name= "<%= i %>"><%= i%></option>
						<%
							}
						%>
					</select>
					<td>
				</tr>
				<tr>
					<td>Start<td>
					<td><select name = "end_day">
					<option name = acutionEnd_day>0</option>
						<%
							for(int i = 1; i<32; i++){
						%>
							<option name= "<%= i %>"><%= i%></option>
						<%
							}
						%>
					</select>
					<td>
					<td>
					<td><select name = "end_month">
					<option name = acutionEnd_month>0</option>
						<%
							for(int i = 1; i<13; i++){
						%>
							<option name= "<%= i %>"><%= i%></option>
						<%
							}
						%>
					</select>
					<td>
					<td>
					<td><select name = "end_year">
					<option name = acutionEnd_year>0</option>
						<%
							for(int i = 2000; i<2014; i++){
						%>
							<option name= "<%= i %>"><%= i%></option>
						<%
							}
						%>
					</select>
					<td>
				</tr>
			</table>
		<td>
	</tr>
		
	
</table>
</br>
	<input value="Search" type="submit">	
	<input value="Reset"type="reset">
</br>
</form>


</center>
</body>


</html>
