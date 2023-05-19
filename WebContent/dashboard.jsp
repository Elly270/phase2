<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<%
		if (session.getAttribute("name") == null) {
			response.sendRedirect("index.jsp?error=1");
		}
	%>
	<b>Hello <%=session.getAttribute("name")%></b>
	<a href="class-list.jsp"> class list</a>
	<a href="student-list.jsp">student list</a>
	<a href="teacher-list.jsp"> teacher list</a>
		<a href="subject-list.jsp">subject list</a>
	
	<a href="logout.jsp"> Logout</a>
</body>