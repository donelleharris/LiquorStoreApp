<%--
  Created by IntelliJ IDEA.
  User: donelleharris
  Date: 11/9/20
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees page</title>
    <jsp:include page="/WEB-INF/partials/head.jsp"/>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>
    <center>
        <a href="/addEmployee"> <button type="submit">Add Employee</button> </a>
        <a href="/create"> <button type="submit">Add Inventory</button> </a>
        <a href="#"> <button type="submit">Delete Inventory</button> </a>
        <a href="/results"> <button type="submit">View All Inventory</button> </a>
    </center>
</body>
</html>
