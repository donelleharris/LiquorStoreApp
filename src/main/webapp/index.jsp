<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Liquor Store</title>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<br>
<center>
    <h1>
        Select the type of Liquor
    </h1>
    <form method="post" action="SelectLiquor">
        <br>
        <select name="category" size="1">
            <c:forEach var="brands" items="${brands}">
                <option value="${brands.category}">${brands.category}</option>
            </c:forEach>
        </select>
        <br><br>
        <input type="submit">
    </form>
</center>


</body>
</html>