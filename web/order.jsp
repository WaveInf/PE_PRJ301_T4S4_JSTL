<%-- 
    Document   : checkout
    Created on : Jun 19, 2023, 2:01:45 PM
    Author     : ASUS
--%>

<%@page import="sample.model.Cart"%>
<%@page import="sample.model.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receipt</title>
    </head>
    <body>
        <form method="post" action="MainController">
            <input type="submit" name="action" value="Back"/>
        </form>
                <h1>${LOGIN_USER.fullName}</h1>
        <c:if test="${sessionScope.ORDER == null || empty sessionScope.ORDER}">
            <c:redirect url = "shopping.html"></c:redirect>
        </c:if>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>ID</th>
                    <th>Product</th>
                    <th>Date</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var = "order" items = "${sessionScope.ORDER}" varStatus = "loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${order.orderID}</td>
                        <td>${order.productName}</td>
                        <td>${order.date}</td>
                        <td>${order.price}</td>
                        <td>${order.quantity}</td>
                        <td>${order.price * order.quantity}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
