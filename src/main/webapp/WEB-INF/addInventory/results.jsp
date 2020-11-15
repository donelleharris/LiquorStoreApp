<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>

<html>
<head>
    <title>Results</title>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<center>
    <div class="container">
        <a href="/employee"> <button type="submit">Employees Main</button> </a>
        <a href="/AddInventory"> <button type="submit">Add Inventory</button> </a>
        <a href="#"> <button type="submit">Delete Inventory</button> </a>
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