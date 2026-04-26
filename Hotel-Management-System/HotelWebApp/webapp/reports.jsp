<%
double r=(Double)request.getAttribute("rev");
%>

<html>
<head>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">

<h2>Revenue Summary</h2>

<div class="stat-box">
Total Revenue:  <%=r%>
</div>

<a href="index.jsp" class="back"> Back</a>

</div>

</body>
</html>