<%-- 
    Document   : viewOrder
    Created on : Jul 6, 2023, 1:34:56 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order View</title>
    </head>
    <body>
        <form method="post" action="MainController">
            <input type="submit" name="action" value="Back to login"/>
        </form>
        <c:if test="${sessionScope.ORDER_LIST == null || empty sessionScope.ORDER_LIST}">
            <c:redirect url = "admin.jsp"></c:redirect>
        </c:if>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>ID</th>
                    <th>User</th>
                    <th>Product</th>
                    <th>Date</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var = "orderList" items = "${sessionScope.ORDER_LIST}" varStatus = "loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${orderList.orderID}</td>
                        <td>${orderList.userID}</td>
                        <td>${orderList.productName}</td>
                        <td>${orderList.date}</td>
                        <td>${orderList.price}</td>
                        <td>${orderList.quantity}</td>
                        <td>${orderList.price * orderList.quantity}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
