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
         
         <a href="list">List All Students</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>ID</th>
                <th>first name</th>
                <th>last name</th>
                
                <th>Class</th>
                
            </tr>
            <c:forEach var="student" items="${listStudent}">
                <tr>
                    <td><c:out value="${student.id}" /></td>
                    <td><c:out value="${student.fname}" /></td>
                    <td><c:out value="${student.lname}" /></td>
                    <td><c:out value="${student.studentClass}" /></td>
                     <a href="edit?id=<c:out value='${student.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${student.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>