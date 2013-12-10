<%@ page language="java" import="java.sql.*"%>
<%

if(request.getParameter("opass").equals("")&&request.getParameter("newpass").equals(request.getParameter("newpass2"))){
%>
<jsp:useBean id="user" class="dgwee.eSaint.Administrator" scope="session"/> 
	<jsp:setProperty name="user" property="*"/> 
<%
user.updateUser();
response.sendRedirect("updateprofile.jsp");
}
else{
response.sendRedirect("updateprofile.jsp?-1");
}


%>
