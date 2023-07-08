<%-- 
    Document   : cart
    Created on : Jun 17, 2023, 2:54:23 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.model.ProductDTO"%>
<%@page import="sample.model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://java.sun.com/jsf/html" xmlns:f="http://java.sun.com/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <form method="post" action="MainController">
            <input type="submit" name="action" value="Back"/>
        </form>
        <h1>Flower deposit</h1>
        <c:if test="${CART == null || empty CART}">
            <c:redirect url = "shopping.html"></c:redirect>
        </c:if>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Operations</th>
                    <th>Total</th>                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var = "cart" items = "${CART.getCart()}" varStatus = "loop">
                <form action="MainController" method="POST">
                    <tr>
                        <td>${loop.count}</td>
                        <td><input type="text" name="id" value="${cart.value.proID}" readonly=""</td>
                        <td>${cart.value.name}</td>
                        <td>${cart.value.price}</td>
                        <td><input type="text" name="quantity" value="${cart.value.quantity}" step="1" min="1" required=""</td>
                        <td>
                            <input type="submit" name="action" value="Edit"/>
                            <input type="submit" name="action" value="Remove"/>
                        </td>
                        <td>${cart.value.quantity * cart.value.price}</td>
                    </tr>
                    <input type="submit" name="action" value="Checkout"/>
                </form>
            </c:forEach>
        </tbody>
    </table>
        ${ERROR}
    <h1> Total: ${TOTAL}</h1>

</body>
</html>
