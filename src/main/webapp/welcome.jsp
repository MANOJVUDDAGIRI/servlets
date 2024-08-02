<%@page import="java.util.List"%>
<%@page import="models.college"%>
<%@page import="dbconnection.collegedb"%>
<%@page import="services.collegeservice"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcomePage</title>
<%@include file="bootstrap.jsp"%>
</head>
<body>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">NAME</th>
      <th scope="col">BRANCH</th>
      <th scope="col">EMAIL</th>
      <th scope="col">ACTION</th>
    </tr>
  </thead>
  <tbody>
  
<%
collegeservice service = new collegeservice(collegedb.conn());
 List<college> ll = service.fetchall();
 
 for(college c:ll){
%>
  	<tr>
      <th><%=c.getId()%></th>
      <td><%=c.getName()%></td>
      <td><%=c.getBranch()%></td>
      <td><%=c.getEmail()%></td>
      <td>
      <a href="update.jsp?id=<%=c.getId()%>">
      <button class="btn btn-outline-warning">Update</button>
      </a>
      <a href="delete?id=<%=c.getId()%>">
      <button class="btn btn-outline-danger">Delete</button>
      </a>
      </td>
    </tr>
    
    <%
    }
    %>
  </tbody>
</table>
</body>
</html>