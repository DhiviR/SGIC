<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>School student management system</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body class="container">
	<header>
        <nav class="navbar navbar-expand-md navbar-dark bg-secondary">
            <div class="container navbar-brand">
                School Student Management System
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath() %>" class="nav-link">Home</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div class="row">
    	<div class="container">
    		<h3>Marks List</h3>
            <hr>
            
            <div class="container text-left">
                <a href="<%=request.getContextPath()%>/add-new-marks" class="btn btn-secondary">Add new marks</a>
            </div>
            <br>
            
            <table class="table table-bordered">
                <thead>
                    <tr>
                    	<th>Marks ID</th>
                        <th>Student ID</th>
                        <th>ExamID</th>
                        <th>Marks</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach var="marks" items="${marksList}">
                        <tr>
                        	<td><c:out value="${marks.marksId}" /></td>
                        	<td><c:out value="${marks.studentId}" /></td>
                        	<td><c:out value="${marks.examId}" /></td>
                        	<td><c:out value="${marks.marks}" /></td>
                        	<td>
                        		<a href="edit-marks?id=<c:out value='${marks.marksId}' />">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        		<a href="delete-marks?id=<c:out value='${marks.marksId}' />">Delete</a>
                        	</td>
                        </tr>
                    </c:forEach>    
                </tbody>
           </table>     
    	</div>
    </div>
    

</body>
</html>