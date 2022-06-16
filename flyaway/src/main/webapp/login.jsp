<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Yannick Vollmer">
    <meta name="keywords" content="FlyAway, book, flights, holiday">
    <meta name="description" content="Book flights to anywhere">
    <link href="global.css" rel="stylesheet" type="text/css">
    <link href="login.css" rel="stylesheet" type="text/css">
    <title>Login - FlyAway</title>
</head>
<body>
     <!-- NAVBAR SECTION -->
     <nav>
        <input id="nav-toggle" type="checkbox">
        <div class="logo">FLY<strong>AWAY</strong></div>
        <ul class="links">
            <li><a href="./index.jsp">Home</a></li>
        </ul>
        <label for="nav-toggle" class="icon-burger">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
        </label>
    </nav>

    <!-- CONTENT SECTION -->
    <main>
        <div class="login">
            <form action="LoginServlet" method="post">
                <fieldset>
                    <legend>LOGIN</legend>
                    <input type="text" name="uname" required placeholder="Username"><br>
                    <input type="password" name="pword" required placeholder="Password"><br>
                    <button type="submit">Login</button><button type="reset">Reset</button>
                </fieldset>
            </form>
        </div>
    </main>
</body>
</html>
