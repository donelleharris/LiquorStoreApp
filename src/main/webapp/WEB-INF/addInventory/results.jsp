<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>

<html>
<head>
    <title>Results</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<center>
    <h1>
        Available Brands
    </h1>
    <%
        List <String> brands = (List) request.getAttribute("brands");
        int quantity = (Integer) request.getAttribute("quantity");
//        Iterator it = results.iterator();

        out.println("<p>We have </p>");

        for (String brand: brands){
            out.println("<p>" + brand + " - " + quantity + "</p>");
        }
    %>
</center>

</body>
</html>