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
         
         <a href="list">List All Subjects</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Subjects</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Class</th>
                
            </tr>
            <c:forEach var="subject" items="${listSubject}">
                <tr>
                    <td><c:out value="${subject.id}" /></td>
                    <td><c:out value="${subject.name}" /></td>
                    <td><c:out value="${subject.className}" /></td>
                     <a href="edit?id=<c:out value='${subject.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${subject.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>