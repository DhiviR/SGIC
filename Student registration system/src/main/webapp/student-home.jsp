<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>School Management System</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body class="container">
	    <header>
        <nav class="navbar navbar-expand-md navbar-dark bg-success">
            <div class="container navbar-brand">
                School Management System
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath() %>/students" class="nav-link">Students List</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
        <div class="container">
            <h3>List of Students</h3>
            <hr>
            <div class="container text-left">
                <a href="<%=request.getContextPath()%>/add-new-student" class="btn btn-success">Add new student</a>
            </div>
            <br>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Grade</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Address</th>
                        <th>Telephone</th>
                    </tr>
                </thead>
                <tbody >
               
                    <c:forEach var="student" items="${listStudent}">
                        <tr>
                            <td><c:out value="${student.id}" /></td>
                            <td><c:out value="${student.name}" /></td>
                            <td><c:out value="${student.grade}" /></td>
                            <td><c:out value="${student.age}" /></td>
                            <td><c:out value="${student.gender}" /></td>
                            <td><c:out value="${student.address}" /></td>
                            <td><c:out value="${student.telephone}" /></td>
                            <td>
                                <a href="edit-student?id=<c:out value='${student.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="delete-student?id=<c:out value='${student.id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                
            </table>
        </div>
    </div>
</body>
</html>