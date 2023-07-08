<%-- 
    Document   : User_Page
    Created on : May 31, 2023, 4:38:43 PM
    Author     : ASUS
--%>

<%@page import="sample.model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
    
        <c:url var = "logoutLink" value = "MainController">
            <c:param name = "action" value = "Logout"></c:param>
        </c:url>
        </br><a href ="${logoutLink}">Log out</a>
        <h1>${LOGIN_USER.fullName} Information</h1>       
        <table border='1' cellspacing='0' cellpadding='4'>
            <thead>
                <tr>
                    <th>Full Name</th>
                    <th>Role ID</th>
                <tr/>
            </thead>
            <tbody>
                <tr>
                    <td>${LOGIN_USER.fullName}</td>
                    <td>${LOGIN_USER.roleID}</td>
                </tr>
            </tbody>
        </table>
        </br><a href ="MainController?action=ShopPage">Shopping Page</a>
    </body>
</html>
