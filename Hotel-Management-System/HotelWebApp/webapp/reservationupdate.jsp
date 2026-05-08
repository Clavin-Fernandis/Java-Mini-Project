<%@ page import="com.hotel.model.Reservation" %>

<html>
<head>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">

<h2>Update Reservation</h2>

<%
String msg = request.getParameter("msg");

if("success".equals(msg)){
%>
<p style="color:green; font-weight:bold;">
Update Successful!
</p>
<%
}else if("fail".equals(msg)){
%>
<p style="color:red; font-weight:bold;">
Update Failed!
</p>
<%
}
%>

<!-- STEP 1: Enter ID -->
<form action="fetchupdate" method="post">

<label>Enter Reservation ID</label>
<input type="number" name="id" min="1" required>

<button type="submit">Fetch Details</button>

</form>

<br>

<%
Reservation r = (Reservation)request.getAttribute("data");

if(r != null){
%>

<!-- STEP 2: Edit Form -->
<form action="update" method="post">

<input type="hidden" name="id"
value="<%=r.getReservationID()%>">

<label>Customer Name</label>
<input type="text" name="name"
value="<%=r.getCustomerName()%>" required>

<label>Room Number</label>
<input type="text" name="room"
value="<%=r.getRoomNumber()%>" required>

<label>Check In</label>
<input type="date" name="checkin"
value="<%=r.getCheckIn()%>" required>

<label>Check Out</label>
<input type="date" name="checkout"
value="<%=r.getCheckOut()%>" required>

<label>Total Amount</label>
<input type="number" name="amount"
value="<%=r.getTotalAmount()%>"
min="0" step="0.01" required>

<button type="submit">Update</button>

</form>

<%
}
%>

<a href="index.jsp">Back</a>

</div>

</body>
</html>