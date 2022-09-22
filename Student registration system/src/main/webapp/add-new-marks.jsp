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
<body>
	<header>
		<nav class="navbar bavbar-expand-md navbar-dark bg-secondary">
            <ul class="navbar-nav">
                <li>
                    <a href="<%=request.getContextPath()%>/marks" class="nav-link">Marks</a>
                </li>
            </ul>

        </nav>
        <br><br>
        <div class="container col-md-5 " >
	        <div class="card" >
	            <div class="card-body">
	                <c:if test="${marks != null}">
	                    <form action="update-marks" method="post">
	                </c:if>
	                <c:if test="${marks == null}">
	                    <form action="insert-marks" method="post">                    
	                </c:if>
	                <caption>
	                    <h2>
	                        <c:if test="${marks != null}">
	                            Edit marks
	                        </c:if>
	                        <c:if test="${marks == null}">
	                            Add new marks
	                        </c:if>
	                    </h2>
                	</caption>
                	<br>
                	
                	<label>Marks ID</label>
                	<fieldset class="form-group">
                		<input type=text name="marksId" value="<c:out value='${marks.marksId}'/>" class="form-control"/>
                	</fieldset>
                	<br>
                	
                	<fieldset>
                		<label>Student ID</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                		<select name="studentId" class="btn btn-secondary dropdown-toggle">
	                		<option value="select" selected>Select student</option>
	                		<c:forEach var="student" items="${listStudent}">
	                			<option value="${student.studentId} ${marks.studentId == student.studentId ? 'selected' : '' }"><c:out value='${student.studentId}' /></option>
	                		</c:forEach>
                		</select>
                	</fieldset>
                	<br>
                	
                	<fieldset>
                		<label>Exam ID</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                		<select name="examId" class="btn btn-secondary dropdown-toggle">
                			<option value="select" selected>Select exam</option>
	                		<c:forEach var="exam" items="${listExam}">
	                			<option value="${exam.examId}"><c:out value='${exam.examId}' /></option>
	                		</c:forEach>
                		</select>
                		
                	</fieldset>
                	<br>
                	
                	<fieldset>
                		<label>Marks</label>
                		<input type="number" name="marks" value="<c:out value='${marks.marks }'/>" class="form-control" />
                	</fieldset>
                	<br>
                	
                	<button type="submit" class="btn btn-success">Save</button>
				</form>
	            </div>
	        </div>
        </div>
        
    </header>

</body>
</html>