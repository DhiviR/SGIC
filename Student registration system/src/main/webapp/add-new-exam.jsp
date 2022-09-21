<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
        <nav class="navbar bavbar-expand-md navbar-dark" style="background-color: blue;">
            <ul class="navbar-nav">
                <li>
                    <a href="<%=request.getContextPath()%>/exams" class="nav-link">Exams</a>
                </li>
            </ul>

        </nav>
    </header>
    <br>
    <div class="container col-md-5 " >
        <div class="card" >
            <div class="card-body">
                <c:if test="${exam != null}">
                    <form action="update-exam" method="post">
                </c:if>
                <c:if test="${exam == null}">
                    <form action="insert-exam" method="post">                    
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${exam != null}">
                            Edit Exam
                        </c:if>
                        <c:if test="${exam == null}">
                            Add new Exam
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${exam != null}">
                    <input type="hidden" name="examId" value="<c:out value='${exam.examId}'/>" class="form-control"/>
                </c:if>
				<br>
					
                <fieldset class="form-group">
                    <label>Term</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <select name="term" class="btn btn-secondary dropdown-toggle">
                        <option value="select the term" selected>Select the term</option>
                        <option value="1" ${exam.term == 1 ? 'selected' : '' }>First Term</option>
                        <option value="2" ${exam.term == 2 ? 'selected' : '' }>Second Term</option>
                        <option value="3" ${exam.term == 3 ? 'selected' : '' }>Third Term</option>
                    </select>
                </fieldset>
                <br>
                <fieldset class="form-group">
                    <label>Grade</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <select name="grade" class="btn btn-secondary dropdown-toggle">
                        <option value="select" selected>Select grade</option>
                        <option value="1" ${exam.grade == 1 ? 'selected' : '' }>1</option>
                        <option value="2" ${exam.grade == 2 ? 'selected' : '' }>2</option>
                        <option value="3" ${exam.grade == 3 ? 'selected' : '' }>3</option>
                        <option value="4" ${exam.grade == 4 ? 'selected' : '' }>4</option>
                        <option value="5" ${exam.grade == 5 ? 'selected' : '' }>5</option>
                        <option value="6" ${exam.grade == 6 ? 'selected' : '' }>6</option>
                        <option value="7" ${exam.grade == 7 ? 'selected' : '' }>7</option>
                        <option value="8" ${exam.grade == 8 ? 'selected' : '' }>8</option>
                        <option value="9" ${exam.grade == 9 ? 'selected' : '' }>9</option>
                        <option value="10" ${exam.grade == 10 ? 'selected' : '' }>10</option>
                        <option value="11" ${exam.grade == 11? 'selected' : '' }>11</option>
                    </select>
                </fieldset>
              	<br>
                <fieldset class="form-group">
                    <label>Subject</label> &nbsp;&nbsp;&nbsp;
                    <select name="subject" class="btn btn-secondary dropdown-toggle">
                        <option value="select" selected>Select subject</option>
                        <option value="Maths" ${exam.subject == 'Maths' ? 'selected' : '' }>Maths</option>
                        <option value="Science" ${exam.subject == 'Science' ? 'selected' : '' }>Science</option>
                        <option value="English" ${exam.subject == 'English' ? 'selected' : '' }>English</option>
                   </select>
                </fieldset>
				<br>
                <button type="submit" class="btn btn-success">Save</button>
			</form>
			
            </div>
        </div>
    </div>
</body>
</html>