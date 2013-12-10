<%@ page language="java" import="java.sql.*"%>
<%@ page import="java.util.*"%>


<jsp:useBean id="item" class="dgwee.eSaint.Item" scope="session"/>
<jsp:setProperty name="item" property="*"/> 
<jsp:useBean id="helper" class="dgwee.eSaint.ESaintDaoHelper" scope="session"/>
<%
	String keyword = requestParameter("keyword");
	double minBid = Double.parseDouble(request.getParameter("minBid"));
	double maxBid = Double.parseDouble(request.getParameter("maxBid"));
	ResultSet rs = helper.searchItems(item.getItemId(), keyword, item.getCategory(), minBid, maxBid, item.getAuctionStart(), item.getAuctionEnd());
	%>
	<table border="1" cellpadding="2"cellspacing="2">
	<tr>
		<td>Item ID<td>
		<td>Item Name<td>
		<td>Category<td>
		<td>Auction Start<td>
		<td>Auction End<td>
		<td>Current Bid<td>
	<%
	 while(rs.next())
	{
	%>
	<tr>
		<td><%= rs.getInt("ITEM_ID") %><td>
		<td><%= rs.getString("ITEM_NAME") %><td>
		<td><%= rs.getString("CATEGORY") %><td>
		<%
		String sd = new java.text.SimpleDateFormat("MM/dd/YYYY").format		 			(rs.getTimestamp("AUCTION_START"));
		%>
		<td><%= sd %><td>
		<%
		String ed = new java.text.SimpleDateFormat("MM/dd/YYYY").format		 			(rs.getTimestamp("AUCTION_END"));
		%>
		<td><%= ed %><td>
		<td><%= rs.getDouble("CURRENT_BID") %><td>
		<td>Item Info<td>
		<td>Bid Now<td>
		
	<tr>
	<%
	}
%>



