<%-- 
    Document   : admin
    Created on : May 31, 2023, 4:38:59 PM
    Author     : ASUS
--%>

<%@page import="java.util.List"%>
<%@page import="sample.model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <c:url var = "logoutLink" value = "MainController">
            <c:param name = "action" value = "Logout"></c:param>
        </c:url>
        </br><a href ="${logoutLink}">Log out</a>
        <h1>${LOGIN_USER.fullName} Information</h1>   
        </br><a href ="MainController?action=ShopPage">Shopping Page</a>
        <c:url var = "orderLink" value = "MainController">
            <c:param name = "action" value = "OrderPage"></c:param>
        </c:url>
        </br><a href ="${orderLink}">View Order</a>
        <form method="post" action="MainController">
            Search<input type="text" name="search" value="${search}"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <c:if test="${LIST_USER != null}">
            <c:if test="${not empty LIST_USER}">
                <table border='1' cellspacing='0' cellpadding='4'>
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>User  ID</th>
                            <th>Full Name</th>
                            <th>Role ID</th>
                            <th>Password</th>
                            <th>Update</th>
                            <th>Delete</th>
                        <tr/>
                    </thead>

                    <tbody>   
                        <c:forEach var = "user" items = "${LIST_USER}" varStatus = "loop">
                        <form action="MainController" method="post">
                            <tr>
                                <td>${loop.count}</td>
                                <td><input type="text" name="userID" value="${user.userID}" readonly=""/></td>

                                <td>
                                    <input type="text" name="fullName" value="${user.fullName}" required=""/>
                                </td>
                                <td>
                                    <input type="text" name="roleID" value="${user.roleID}" required=""/>
                                </td>
                                <td>${user.password}</td>
                                <td>
                                    <button type="submit" name="action" value="Update">Update</button>
                                    <input type="hidden" name="search" value="${search}"/>                                                                       
                                </td>
                                <td>
                                    <c:url var = "deleteLink" value = "MainController">
                                        <c:param name = "action" value="Delete"></c:param>
                                        <c:param name = "userID" value="${user.userID}"></c:param>
                                        <c:param name = "search" value="${search}"></c:param>                                       
                                    </c:url>
                                    <a href ="${deleteLink}">Delete</a>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
            
        </c:if>
    </c:if>    
    ${ERROR}

</body>
</html>
