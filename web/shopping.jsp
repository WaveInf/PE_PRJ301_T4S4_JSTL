<%-- 
    Document   : shopping
    Created on : Jun 17, 2023, 3:58:02 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flower store</title>
    </head>
    <body>
        <form method="post" action="MainController">
            <input type="submit" name="action" value="Back to login"/>
            <input type="submit" name="action" value="Order"/>
        </form>
        <a href ="MainController?action=CartPage">Cart</a>
        <h1>Welcome to our store !</h1>
        <form action="MainController">
            <select name="cmbFlower">
                <option value="F01-Coin Flower-20">Coin Flower 20$</option>
                <option value="F02-Sun Flower-30">Sun Flower 30$</option>
                <option value="F03-Daisy Flower-15">Daisy Flower 15$</option>
                <option value="F04-Rose Flower-50">Rose Flower 50$</option>
            </select>
            <select name="cmbQuantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="10">10</option>
            </select>
            <input type="submit" name="action" value="Add"/>
        </form>
        ${MESSAGE}
    </body>
</html>
