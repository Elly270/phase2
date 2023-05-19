<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Learner's Academy</title>
</head>
<body>
 <center>
        <h2>
         
         <a href="list">List all teachers</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of teachers</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Class</th>
                
            </tr>
            <c:forEach var="teacher" items="${listTeacher}">
                <tr>
                    <td><c:out value="${teacher.id}" /></td>
                    <td><c:out value="${teacher.teacherName}" /></td>
                    <td><c:out value="${teacher.teacherClasses}" /></td>
                     <a href="edit?id=<c:out value='${teacher.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${teacher.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>