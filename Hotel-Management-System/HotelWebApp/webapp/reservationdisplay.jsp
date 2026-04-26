<%@ page import="java.util.*,com.hotel.model.Reservation" %>

<html>
<head>
<title>All Reservations</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">

<h2>Reservation Records</h2>

<table>

<tr>
<th>ID</th>
<th>Name</th>
<th>Room</th>
<th>CheckIn</th>
<th>CheckOut</th>
<th>Amount</th>
</tr>

<%
List<Reservation> list =
(List<Reservation>)request.getAttribute("data");

if(list!=null){
for(Reservation r:list){
%>

<tr>
<td><%=r.getReservationID()%></td>
<td><%=r.getCustomerName()%></td>
<td><%=r.getRoomNumber()%></td>
<td><%=r.getCheckIn()%></td>
<td><%=r.getCheckOut()%></td>
<td><%=r.getTotalAmount()%></td>
</tr>

<%
}
}
%>

</table>

<br>
<a href="index.jsp" style="color:#1e3c72;">Back</a>

</div>

</body>
</html>