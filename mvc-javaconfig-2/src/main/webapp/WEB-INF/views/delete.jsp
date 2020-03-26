<%@page import="com.cognizant.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Page</title>
</head>
<body>
	<%
		Student student = (Student) request.getAttribute("student");
	%>
	<h1>Record to Delete</h1>
	<form:form action="" method="post" modelAttribute="student">
		<label>Id: <%
			out.println(student.getId());
		%></label>
		<br>
		<label>Name: <%
			out.println(student.getName());
		%></label>
		<br>
		<label>Marks: <%
			out.println(student.getMarks());
		%></label>
		<br>

		<input type="submit" name="submit" value="delete" />

	</form:form>
</body>
</html>