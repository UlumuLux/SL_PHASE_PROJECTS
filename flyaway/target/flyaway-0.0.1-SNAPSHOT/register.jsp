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
    <link href="./register.css" rel="stylesheet" type="text/css">
    <title>Register - FlyAway</title>
</head>
<body>
     <!-- NAVBAR SECTION -->
     <nav>
        <input id="nav-toggle" type="checkbox">
        <div class="logo">FLY<strong>AWAY</strong></div>
        <ul class="links">
            <li><a href="./login.jsp">Login</a></li>
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
        <form action="RegisterServlet" method="post">
            <fieldset>
                <legend>REGISTER</legend>
                <table>
                    <thead>
                        <!-- NONE -->
                    </thead>
                    <tbody>
                         <tr>
                            <td><label for="uname">Username:</label></td>
                            <td><input type="text" name="uname" id="uname" placeholder="Username" required></td>
                        </tr>
                             <tr>
                            <td><label for="pass">First Name:</label></td>
                            <td><input type="password" name="pass" id="pass" placeholder="Password" required></td>
                        </tr>
                        <tr>
                            <td><label for="fname">First Name:</label></td>
                            <td><input type="text" name="fname" id="fname" placeholder="first name" required></td>
                        </tr>
                        <tr>
                            <td><label for="lname">Last Name:</label></td>
                            <td><input type="text" name="lname" id="lname" placeholder="last name" required></td>
                        </tr>
                        <tr>
                            <td><label for="city">City:</label></td>
                            <td><input type="text" name="city" id="city" placeholder="city" required>
                                <input type="text" name="postcode" placeholder="postal code" required></td>
                        </tr>
                        <tr>
                            <td><label for="street">Street:</label></td>
                            <td><input type="text" name="street" id="street" placeholder="street" required>
                                <input type="number" name="housenumber" placeholder="house number" required></td>
                        </tr>
                        <tr>
                            <td><label for="phone">Phone:</label></td>
                            <td><input type="text" name="phone" id="phone" placeholder="phone number (optional)"></td>
                        </tr>
                        <tr>
                            <td><label for="email">Email:</label></td>
                            <td><input type="email" name="email" id="email" placeholder="email"></td>
                        </tr>
                        <tr>
                            <td><button type="submit">Register</button></td>
                            <td><button type="reset">Reset</button></td>
                        </tr>
                    </tbody>
                </table>
            </fieldset>
        </form>
    </main>
</body>
</html>
