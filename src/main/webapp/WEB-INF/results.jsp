
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<body>
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
            out.println("<p>" + brand + "</p>");
        }
        out.println("<p>Stock Quantity: " + quantity + "</p>");
    %>
</center>

</body>
</html>