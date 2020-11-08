<%--
  Created by IntelliJ IDEA.
  User: donelleharris
  Date: 11/7/20
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a Product</title>
</head>
<body>
    <h1>Create A Product</h1>
    <form action="/AddLiquor" method="post">
        <label for="liquorName">Name</label>
        <input type="text" name="liquorName" id="liquorName">
        <br>
        <label for="quantity">Quantity</label>
        <input type="text" name="quantity" id="quantity">
        <br>
        <label for="liquorType">Category</label>
        <select name="liquorType" id="liquorType">
            <option value="BOURBON">BOURBON</option>
            <option value="WINE">WINE</option>
            <option value="BEER">BEER</option>
            <option value="VODKA">VODKA</option>
            <option value="SCOTCH">SCOTCH</option>
            <option value="GIN">GIN</option>
        </select>
        <button type="submit">Add Liquor</button>

    </form>
</body>
</html>
