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
                    <a href="<%=request.getContextPath()%>/students" class="nav-link">Students</a>
                </li>
            </ul>

        </nav>
    </header>
    <br>
    <div class="container col-md-5" >
        <div class="card" style="height: 500px" >
            <div class="card-body">
                <c:if test="${student != null}">
                    <form action="update-student" method="post">
                </c:if>
                <c:if test="${student == null}">
                    <form action="insert-student" method="post">                    
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${student != null}">
                            Edit Student
                        </c:if>
                        <c:if test="${student == null}">
                            Add new student
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${student != null}">
                    <input type="hidden" name="id" value="<c:out value='${student.id}'/>" class="form-control"/>
                </c:if>

                <fieldset class="form-group">
                    <label>Name</label>
                    <input type="text" value="<c:out value='${student.name}' />" class="form-control" name="name"
                        required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Grade</label>
                    <select name="grade" class="btn btn-secondary dropdown-toggle">
                        <option value="select" selected>Select grade</option>
                        <option value="1" ${student.grade == 1 ? 'selected' : '' }>1</option>
                        <option value="2" ${student.grade == 2 ? 'selected' : '' }>2</option>
                        <option value="3" ${student.grade == 3 ? 'selected' : '' }>3</option>
                        <option value="4" ${student.grade == 4 ? 'selected' : '' }>4</option>
                        <option value="5" ${student.grade == 5 ? 'selected' : '' }>5</option>
                        <option value="6" ${student.grade == 6 ? 'selected' : '' }>6</option>
                        <option value="7" ${student.grade == 7 ? 'selected' : '' }>7</option>
                        <option value="8" ${student.grade == 8 ? 'selected' : '' }>8</option>
                        <option value="9" ${student.grade == 9 ? 'selected' : '' }>9</option>
                        <option value="10" ${student.grade == 10 ? 'selected' : '' }>10</option>
                        <option value="11" ${student.grade == 11? 'selected' : '' }>11</option>
                    </select>
                </fieldset>
                <fieldset class="form-group">
                    <label>Age</label>
                    <input type="number" value="<c:out value='${student.age}' />" class="form-control" name="age"
                        required="required">
                </fieldset>    

                <fieldset class="form-group">
                    <label for="gender">Gender</label>

                    <input type="radio" name="gender" id="male" ${student.gender=='Male' ? 'checked' : '' } value="Male">
                    <label for="Male">Male</label>

                    <input type="radio" name="gender" id="female" ${student.gender=='Female' ? 'checked' : '' }  value="Female">
                    <label for="female">Female</label>
                </fieldset>
                
                <fieldset class="form-group">
                    <label>Address</label>
                    <input type="text" value="<c:out value='${student.address}' />" class="form-control" name="address"
                        required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Telephone</label>
                    <input type="text" value="<c:out value='${student.telephone}' />" class="form-control" name="telephone"
                        required="required">
                </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
			</form>
			
            </div>
        </div>
    </div>
</body>
</html>