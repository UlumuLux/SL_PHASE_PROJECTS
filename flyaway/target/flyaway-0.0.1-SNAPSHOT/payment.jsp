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
    <link href="./payment.css" rel="stylesheet" type="text/css">
    <title>Payment - FlyAway</title>
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
        <div class="start">
          <form action="./payment_confirmation.html">
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
                        <button type="submit">Buy now</button><button type="reset"><a id="abort" href="./index.html">Abort</a></button>
                </fieldset>
          </form>
        </div>
    </main>
</body>
</html>
