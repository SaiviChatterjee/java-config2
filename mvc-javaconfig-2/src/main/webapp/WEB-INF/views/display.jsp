<%@page import="java.util.List"%>
<%@page import="com.cognizant.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Marks</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Student> list = (List<Student>)request.getAttribute("list");
			%>

			<%
				for (Student s : list) {
			%>
			<tr>
				<td><%=s.getId()%></td>
				<td><%=s.getName()%></td>
				<td><%=s.getMarks()%></td>
				<td><a href="update?id=<%=s.getId()%>" >Update</a></td>
				<td><a href="delete?id=<%=s.getId()%>" >Delete</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<br>
	<a href="insert" >Add</a>
</body>
</html>