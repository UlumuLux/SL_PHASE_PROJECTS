<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*" %>
<%@ page import="java.net.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.vollmer.flyaway.dto.*" %>
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
    <link href="adminPage.css" rel="stylesheet" type="text/css">
    <title>Admin - FlyAway</title>
</head>
<body>
    <!-- NAVBAR SECTION -->
    <nav>
        <input id="nav-toggle" type="checkbox">
        <div class="logo">FLY<strong>AWAY</strong></div>
        <ul class="links">
         <% Cookie cookie = null;
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
    <% ArrayList<Flight> flights = (ArrayList<Flight>) request.getAttribute("flights"); %>
    <% ArrayList<Source> sources = (ArrayList<Source>) request.getAttribute("sources"); %>
    <% ArrayList<Destination> destinations = (ArrayList<Destination>) request.getAttribute("destinations"); %>
    <% ArrayList<Airline> airlines = (ArrayList<Airline>) request.getAttribute("airlines"); %>
    <main>
    <div id="wrapper">
    <div id="changePW">
    	<form action="ChangeServlet" method="post">
    		<label for="pw">Change Admin Password:</label>
    		<input type="password" name="pw" id="pw" />
    		<button type="submit">Change</button>
    	</form>
    </div>
    <div id="flights">
    <table>
    		<thead>
    			<tr>
    				<th>Flight-Id</th>
    				<th>Source</th>
    				<th>Destination</th>
    				<th>Airline</th>
    				<th>Date</th>
    				<th>Time</th>
    				<th>Price</th>
    			</tr>
    		</thead>
    		<tbody>
    		   <% for(Flight f : flights) {
        			out.print("<tr><td>" + f.getId() + "</td>");
        			out.print("<td>" + f.getSource() + "</td>");
        			out.print("<td>" + f.getDest() + "</td>");
        			out.print("<td>" + f.getAirline() + "</td>");
        			out.print("<td>" + f.getDate() + "</td>");
        			out.print("<td>" + f.getTime() + "</td>");
        			out.print("<td>$" + f.getPrice() + "</td></tr>");
        		} %>
    		</tbody>
    	</table>
    </div>
    <div id="sources">
    <table>
    		<thead>
    			<tr>
    				<th>Source-Id</th>
    				<th>Source</th>
    			</tr>
    		</thead>
    		<tbody>
    		   <% for(Source s : sources) {
        			out.print("<tr><td>" + s.getId() + "</td>");
        			out.print("<td>" + s.getName() + "</td></tr>");
        		} %>
    		</tbody>
    	</table>
    	</div>
    <div id="destinations">
    <table>
    		<thead>
    			<tr>
    				<th>Destination-Id</th>
    				<th>Destination</th>
    			</tr>
    		</thead>
    		<tbody>
    		   <% for(Destination d : destinations) {
        			out.print("<tr><td>" + d.getId() + "</td>");
        			out.print("<td>" + d.getName() + "</td></tr>");
        		} %>
    		</tbody>
    	</table>
    </div>
    <div id="airlines">
    <table>
    		<thead>
    			<tr>
    				<th>Airline-Id</th>
    				<th>Airline</th>
    			</tr>
    		</thead>
    		<tbody>
    		   <% for(Airline a : airlines) {
        			out.print("<tr><td>" + a.getId() + "</td>");
        			out.print("<td>" + a.getName() + "</td></tr>");
        		} %>
    		</tbody>
    	</table>
    </div>  
    </div>		
    </main>
</body>
</html>