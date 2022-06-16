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
    <link href="payment.css" rel="stylesheet" type="text/css">
    <title>Payment - FlyAway</title>
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
     <% String source = (String) request.getAttribute("source"); %>
     <% String dest = (String) request.getAttribute("dest"); %>
     <% String airline = (String) request.getAttribute("airline"); %>
     <% String date = (String) request.getAttribute("date"); %>
     <% String time = (String) request.getAttribute("time"); %>
     <% String price = (String) request.getAttribute("price"); %>
     <% String ppl = (String) request.getAttribute("ppl"); %>
     <main>
        <div class="start">
        <p>CHOOSE PAYMENT OPTION FOR FLIGHT:</p>
        <pre>
        	Source: <%= source %>
        	Destination: <%= dest %>
        	Airline: <%= airline %>
        	Date: <%= date %>
        	Time: <%= time %>
        	Price (for <%= ppl %> persons): $<%= price %>
        </pre>
          <form action="./payment_confirmation.jsp">
                <fieldset>
                    <legend>PAYMENT</legend>
                    <label for="payopt">Payment option:</label>
                    <select name="payopt" id="payopt">
                        <option value="credit-card">Credit card</option>
                        <option value="paypal">Paypal</option>
                        <option value="e-bank">E-bank</option>
                        </select><br><br>
                        <label for="accept">I accept the <a href="#">terms of use</a> and <a href="#">privacy policy</a></label>
                        <input type="checkbox" id="accept" value="accepted" required>
                        <br><br>
                        <button type="submit">Buy now</button><button type="reset"><a id="abort" href="./index.jsp">Abort</a></button>
                </fieldset>
          </form>
        </div>
    </main>
</body>
</html>
