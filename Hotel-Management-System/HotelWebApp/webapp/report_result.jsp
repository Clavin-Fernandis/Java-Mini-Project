<%@ page import="java.util.*,com.hotel.model.Reservation" %>

<html>
<head>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">

<%
double rev=(Double)request.getAttribute("rev");
String room=(String)request.getAttribute("room");
List<Reservation> list=
(List<Reservation>)request.getAttribute("data");
%>

<h2>Executive Analytics</h2>

<div class="stat-grid">
<div class="stat-box">
Revenue <br>  <%=rev%>
</div>

<div class="stat-box">
Top Room <br> <%=room%>
</div>
</div>

<h3>Total Revenue:  <%=rev%></h3>
<h3>Most Booked Room: <%=room%></h3>

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
%>

</table>

<br>
<a href="index.jsp" style="color:#1e3c72;">Back</a>

</div>

</body>
</html>