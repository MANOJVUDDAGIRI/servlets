<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servlets</title>
</head>
<body>
<form action="register" method="post">

<input type = "hidden" name = "id">

<input type ="text" placeholder = "enter name" class="form-control" name ="name">

<input type ="text" placeholder = "enter branch" class="form-control" name ="branch">

<input type ="text" placeholder = "enter email" class="form-control" name ="email">

<button type ="submit">Register</button>

</form>
</body>
</html>