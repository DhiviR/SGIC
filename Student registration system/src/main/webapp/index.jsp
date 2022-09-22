<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>School Management System</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body class="container bg-dark align-center">


<div style="top:50px">
<h1 style="color:white; position: absolute; left: 350px; top: 50px;">School student management system</h1>
</div>


	<div class="card" style="width: 200px; top:200px; left:450px">
		<ul class="list-group list-group-flush">
		    <li class="list-group-item">
			    <form action="students" method="post" >
					<button class="btn btn-primary form-control" type="submit">Students</button>
				</form>
		    </li>
		    <li class="list-group-item">
				<form action="exams" method="post">
					<button class="btn btn-warning form-control" type="submit">Examination</button>
				</form>
			</li>
			<li class="list-group-item">
				<form action="results" method="post">
					<button class="btn btn-secondary form-control" type="submit">Results</button>
				</form>
			</li>
		    
  		</ul>
	</div>

	
	
</body>
</html>