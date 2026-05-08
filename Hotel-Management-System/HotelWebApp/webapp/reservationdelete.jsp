<%@ page import="com.hotel.model.Reservation" %>

<html>
<head>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">

<h2>Cancel Reservation</h2>

<!-- STEP 1: Enter ID -->
<form action="fetch" method="post">

<label>Reservation ID</label>
<input type="number" name="id" min="1" required>

<button type="submit">Fetch Details</button>

</form>

<br>

<%
Reservation r = (Reservation)request.getAttribute("data");

if(r != null){
%>

<h3>Customer Name: <%=r.getCustomerName()%></h3>
<h3>Room: <%=r.getRoomNumber()%></h3>

<!-- STEP 2: Confirm Delete -->
<form action="delete" method="post"
onsubmit="return confirm('Are you sure you want to delete this reservation?');">

<input type="hidden" name="id" value="<%=r.getReservationID()%>">

<button type="submit">Confirm Delete</button>

</form>

<%
}
%>

<a href="index.jsp">Back</a>

</div>

</body>
</html>