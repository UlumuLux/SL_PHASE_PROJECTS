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
    <link href="search.css" rel="stylesheet" type="text/css">
    <title>Search - FlyAway</title>
</head>
<body>
    <!-- NAVBAR SECTION -->
    <nav>
        <input id="nav-toggle" type="checkbox">
        <div class="logo">FLY<strong>AWAY</strong></div>
        <ul class="links">
        <% 	Cookie cookie = null;
        	Cookie[] cookies = null;
        	cookies = request.getCookies();
        	boolean cont = true;
        	if(cookies != null) {
        		for(Cookie c : cookies) {
        			if(c.getName().equals("user")) {
            			out.print("<li><a>Welcome " + c.getValue() + "!</a></li>");
            			out.print("<li><a href='LogoutServlet'>Logout</a></li>");
            			cont = false;
        			}
        		}
        		if(cont){
        			out.print("<li><a href='./login.jsp'>Login</a></li>");
        		}	
        	}
       	 %>
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
        <div class="search">
            <form action="SearchServlet" method="post">
                <fieldset>
                    <legend>FLIGHT-SEARCH</legend>
                    <table>
                        <thead>
                            <!-- NONE -->
                        </thead>
                        <tbody>
                            <tr>
                                <td><label for="date">Day of travel:</label></td>
                                <td><input type="date" id="date" name="date" required></td>
                            </tr>
                            <tr>
                                <td><label for="source">Source:</label></td>
                                <td><input type="text" id="source" name="source" placeholder="enter source here" required></td>
                            </tr>
                            <tr>
                                <td><label for="dest">Destination:</label></td>
                                <td><input type="text" id="dest" name="dest" placeholder="enter destination here" required></td>
                            </tr>
                            <tr>
                                <td><label for="ppl">Number of travelers:</label></td>
                                <td><input type="number" id="ppl" name="ppl" placeholder="2" min="1" max="10"></td>
                            </tr>
                            <tr>
                                <td><button type="submit">Search</button></td>
                                <td><button type="reset">Reset</button></td>
                            </tr>
                        </tbody>
                    </table>
                </fieldset>
            </form>
        </div>
    </main>
</body>
</html>
