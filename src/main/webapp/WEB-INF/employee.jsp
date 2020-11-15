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
    <center>
        <div class="container">
            <h1>Welcome, ${sessionScope.user.username}!</h1>

            <center>
                <a href="/addEmployee"> <button type="submit">Add Employee</button> </a>
                <a href="/AddInventory"> <button type="submit">Add Inventory</button> </a>
                <a href="#"> <button type="submit">Delete Inventory</button> </a>
            </center>
            <h1>Current Inventory</h1>

            <c:forEach var="brand" items="${brands}">
                <div class="col-md-4">
                    <h2>${brand.brand}</h2>
                    <p>${brand.quantity}</p>
                    <p>${brand.category}</p>
                </div>
            </c:forEach>
        </div>
    </center>
</body>
</html>
