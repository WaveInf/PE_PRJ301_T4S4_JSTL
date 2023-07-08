<%-- 
    Document   : login
    Created on : May 31, 2023, 4:52:15 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER != null && sessionScope.LOGIN_USER.roleID == 'AD'}">
            <c:redirect url = "admin.jsp"></c:redirect>
        </c:if>
        <c:if test="${sessionScope.LOGIN_USER != null && sessionScope.LOGIN_USER.roleID == 'US'}">
            <c:redirect url = "user.jsp"></c:redirect>
        </c:if>
        Input user's information
        <form action="MainController" method="POST">
            UserID<input type="text"  name="userID" required/>
            </br>Password<input type="password"  name="password" required/>
            </br>
            <label>Remember me</label> <input type="checkbox" name="remember" value="1"/>
            </br><input type="submit"  name="action" value="Login"/>
            <input type="reset" value="Reset"/>
        </form> 
        <div style="color: red">${ERROR}</div>
        <a href ="MainController?action=CreatePage">Create Page</a>
        </br><a href ="MainController?action=ShopPage">Shopping Page</a>
    </body>
</html>
