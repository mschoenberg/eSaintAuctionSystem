<%@ page language="java" import="java.sql.*"%>
<%@ page import="java.util.*"%>

<% 
	String userType = request.getParameter("userType");
	
	if( userType.equals("admin") ){
%>
	<jsp:useBean id="admin" class="awzurn.eSaint.Administrator" scope="session"/> 
	<jsp:setProperty name="admin" property="*"/> 
<% 
	  if ( admin.login() ){
	    response.sendRedirect("administrator/admin_portal.jsp");
	  }
	  else{
	    response.sendRedirect("login.jsp?error=-1"); //change the login page to display an error
	  }
	}
	else{
%>
	<jsp:useBean id="user" class="awzurn.eSaint.User" scope="session"/> 
	<jsp:setProperty name="user" property="*"/> 
<%	
	  if ( user.login() ){
	    response.sendRedirect("user/user_portal.jsp");
	  }
	  else{
	    response.sendRedirect("login.jsp?error=-1"); //change the login page to display an error
	  }
	}
%> 


