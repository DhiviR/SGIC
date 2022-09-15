<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student registration system</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
	    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue;">
            <div class="navbar-brand">
                Student registration system
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath() %>/list" class="nav-link">Students List</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
        <div class="container">
            <h3>List of Students</h3>
            <hr>
            <div class="container text-left">
                <a href="<%=request.getContextPath()%>/register" class="btn btn-success">Add new student</a>
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
                <tbody>
                    <c:forEach var="user" items="${listUser}">
                        <tr>
                            <td><c:out value="${user.id}" /></td>
                            <td><c:out value="${user.name}" /></td>
                            <td><c:out value="${user.grade}" /></td>
                            <td><c:out value="${user.age}" /></td>
                            <td><c:out value="${user.gender}" /></td>
                            <td><c:out value="${user.address}" /></td>
                            <td><c:out value="${user.telephone}" /></td>
                            <td>
                                <a href="edit?id=<c:out value='${user.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="delete?id=<c:out value='${user.id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                
            </table>
        </div>
    </div>
</body>
</html>