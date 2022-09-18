<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>School management system</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<header>
        <nav class="navbar navbar-expand-md navbar-dark bg-warning">
            <div class="navbar-brand">
                School Management System
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath() %>/listExam" class="nav-link">Exams</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
        <div class="container">
            <h3>List of Exams</h3>
            <hr>
            <div class="container text-left">
                <a href="<%=request.getContextPath()%>/register" class="btn btn-warning">Add new exam</a>
            </div>
            <br>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Term</th>
                        <th>Grade</th>
                        <th>Subject Name</th>
                    </tr>
                </thead>
                <tbody >
                    <c:forEach var="exam" items="${listExam}">
                        <tr>
                            <td><c:out value="${exam.id}" /></td>
                            <td><c:out value="${exam.term}" /></td>
                            <td><c:out value="${exam.grade}" /></td>
                            <td><c:out value="${exam.subjectName}" /></td>
                            <td>
                                <a href="edit?id=<c:out value='${student.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="delete?id=<c:out value='${student.id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                
            </table>
        </div>
    </div>

</body>
</html>