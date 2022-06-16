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
    <link href="availableFlights.css" rel="stylesheet" type="text/css">
    <title>Flights - FlyAway</title>
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
    <% String source = (String) request.getAttribute("source"); %>
    <% String dest = (String) request.getAttribute("dest"); %>
    <% int ppl = Integer.parseInt((String) request.getAttribute("ppl")); %>
    <% ArrayList<Airline> airlines = (ArrayList<Airline>) request.getAttribute("airlines"); %>
    <% String airL = null; %>
    <main>
    <form action="PaymentServlet" method="post">
        <div class="flightList">
        <p id="available">A V A I L A B L E <strong>F L I G H T S</strong></p>
   			<table>
    		<thead>
    			<tr>
    				<th>FROM</th>
    				<th>TO</th>
    				<th>AIRLINE</th>
    				<th>DATE</th>
    				<th>TIME</th>
    				<th>PRICE</th>
    				<th>BOOKING FOR</th>
    				<th>SELECT</th>
    			</tr>
    		</thead>
    		<tbody>
    		   <% for(Flight f : flights) {
    			   for(Airline a : airlines) {
    				   if(a.getId() ==  Integer.parseInt(f.getAirline())) {
    					   airL = a.getName();
    				   }
    			   }
        			out.print("<td>" + source + "</td>");
        			out.print("<td>" + dest + "</td>");
        			out.print("<td>" + airL + "</td>");
        			out.print("<td>" + f.getDate() + "</td>");
        			out.print("<td>" + f.getTime() + "</td>");
        			out.print("<td>$" + (f.getPrice() * ppl) + "</td>");
        			out.print("<td>" + ppl + "</td>");
        			out.print("<td><input type='radio' name='selected' value='" + f.getSource() + ";" +
        					f.getDest() + ";" + f.getAirline() + ";" + f.getDate() + ";"
        					+ f.getTime() + ";" + (f.getPrice() * ppl) + ";" + ppl + "' required/></td></tr>");
        		} %>
    		</tbody>
    	</table>
    	<button type="submit">Go to Payment</button>
        </div>
        </form>
    </main>
</body>
</html>
