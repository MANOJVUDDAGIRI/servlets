<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="models.college"%>
<%@page import="dbconnection.collegedb"%>
<%@page import="services.collegeservice"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int id =Integer.parseInt(request.getParameter("id"));
collegeservice service = new collegeservice(collegedb.conn());
college stm = service.getbyid(id);
%>
<form action="update" method="post">
<input type="text" placeholder="update your name" name="name" value="<%= stm.getName()%>">
<input type="email" placeholder="update your email" name="email"<%= stm.getEmail() %>>
<input type="text" placeholder="update your bramch" name="branch"<%= stm.getBranch() %>>
<button>Update</button>
</form>
</body>
</html>