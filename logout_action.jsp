<%@ page language="java" import="java.sql.*"%>

<%
  int type = request.getParameter("type");
  if( type == 1 ){ //admin logging out
%>

<jsp:useBean id="admin" class="awzurn.Administrator" scope="session"/>

<%
    try{
	  admin.logout();
	}
	catch(IllegalStateException ise){
        out.println(ise.getMessage());
    }
    response.sendRedirect("login.jsp");
  }
  else{ //user logging out
%>

<jsp:useBean id="user" class="awzurn.User" scope="session"/>

<%

  try{
	  user.logout();
	}
	catch(IllegalStateException ise){
        out.println(ise.getMessage());
    }
    response.sendRedirect("login.jsp?name=" + user.getFirstName() );
  }
  
%>
