<html>
<head>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">

<h2>Update Reservation</h2>

<form action="update" method="post">

<input type="number" name="id" placeholder="Reservation ID" required>
<input type="text" name="name" placeholder="Customer Name" required>
<input type="text" name="room" placeholder="Room Number" required>
<input type="date" name="checkin" required>
<input type="date" name="checkout" required>
<input type="number" name="amount" required>

<button type="submit">Update</button>

</form>
</div>
</body>
</html>