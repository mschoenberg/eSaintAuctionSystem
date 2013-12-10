<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<jsp:useBean id="admin" class="dgwee.eSaint.Administrator" scope="session"/> 
<% out.println(admin.getUsername());%>
<%
ResultSet rs = admin.getSalesReport();

%>
