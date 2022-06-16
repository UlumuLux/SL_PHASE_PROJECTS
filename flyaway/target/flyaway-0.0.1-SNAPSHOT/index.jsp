<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Arrays"%>
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
    <link href="index.css" rel="stylesheet" type="text/css">
    <title>Welcome - FlyAway</title>
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
            <li><a href="./register.jsp">Register</a></li>
        </ul>
        <label for="nav-toggle" class="icon-burger">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
        </label>
    </nav>

    <!-- CONTENT SECTION -->
    <main>
        <div class="start">
          <form action="./search.jsp">
            <p id="start-text">START BOOKING NOW!</p> <button type="submit">
              <div id="arrowAnim">
                  <div class="arrowSliding">
                    <div class="arrow"></div>
                  </div>
                  <div class="arrowSliding delay1">
                    <div class="arrow"></div>
                  </div>
                  <div class="arrowSliding delay2">
                    <div class="arrow"></div>
                  </div>
                  <div class="arrowSliding delay3">
                    <div class="arrow"></div>
                  </div>
                </div>
          </button>
          </form>
        </div>
    </main>
</body>
</html>
