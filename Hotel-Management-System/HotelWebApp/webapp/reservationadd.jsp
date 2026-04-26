<%@ page language="java" %>
<html>
<head>
<title>Add Reservation</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">

<h2>Add Reservation</h2>

<form action="add" method="post">

<input type="number" name="id" placeholder="Reservation ID" required>

<input type="text" name="name" placeholder="Customer Name" required>

<input type="text" name="room" placeholder="Room Number" required>

<label>Check In</label>
<input type="date" name="checkin" required>

<label>Check Out</label>
<input type="date" name="checkout" required>

<input type="number" step="0.01" name="amount" placeholder="Total Amount" required>

<button type="submit">Book Now</button>

</form>

<br>
<a href="index.jsp" style="color:#1e3c72;">Back</a>

<%
String msg=request.getParameter("msg");

if("success".equals(msg)){
%>
<p style="color:green;">Reservation Added Successfully!</p>
<%
}
if("fail".equals(msg)){
%>
<p style="color:red;">Failed to Add Reservation!</p>
<%
}
%>

</div>

</body>
</html>