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
         
         <a href="list">List All classes</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of classes</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Teacher</th>
                <th>subjects</th>
                
                
            </tr>
            <c:forEach var="className" items="${listClass}">
                <tr>
                    <td><c:out value="${className.id}" /></td>
                    <td><c:out value="${className.name}" /></td>
                    <td><c:out value="${className.teacher}" /></td>
                    <td><c:out value="${className.subjects}" /></td>
                    <td><c:out value="${className.listOfStudents}" /></td>
                     <a href="edit?id=<c:out value='${className.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${className.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>