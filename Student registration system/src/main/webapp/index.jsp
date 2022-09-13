<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
    </head>

    <link rel="stylesheet" href="css/registration.css">

    <body>
        <div class="container">
            <form action="register" method="post">
                <h1>Registration form</h1>

                <div>
                    <label for="name">Name</label>
                    <input type="text" placeholder="Enter your name" name="name">
                </div>

                <div>
                    <label for="grade">Grade</label>
                    <select name="grade" id="">
                        <option value="select" selected>Select grade</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                    </select>
                </div>

                <div class="sex">
                    <label for="sex">Sex</label>

                    <input type="radio" name="sex" id="male">
                    <label for="Male">Male</label>

                    <input type="radio" name="sex" id="female">
                    <label for="female">Female</label>
                </div>

                <div>
                    <label for="age">Age</label>
                    <input type="number" name="age" id="age">
                </div>

                <div>
                    <label for="address">Address</label>
                    <input type="text" name="address" id="address">
                </div>

                <div>
                    <label for="telephone">Telephone</label>
                    <input type="tel" name="telephone" id="telephone">
                </div>

                <button type="submit">Register</button>
            </form>
        </div>
    </body>

    </html>