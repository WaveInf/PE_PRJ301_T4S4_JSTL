<%-- 
    Document   : create
    Created on : Jun 10, 2023, 4:30:13 PM
    Author     : ASUS
--%>

<%@page import="sample.model.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create user</title>
    </head>
    <body>
        <form method="post" action="MainController">
            <input type="submit" name="action" value="Back"/>
        </form>
        Create user
        <form action="MainController" method="post">
            UserID<input type="text" name="userID" required=""/>${USER_ERROR.userIDError}
            </br>Full name<input type="text" name="fullName" required=""/>${USER_ERROR.fullNameError}
            </br>Role ID<input type="text" name="roleID" value="US" readonly=""/>${USER_ERROR.roleIDError}
            </br>Password<input type="password" name="password" required=""/>${USER_ERROR.passwordError}
            </br>Confirm<input type="password" name="confirm" required=""/>${USER_ERROR.confirmError}
            </br><input type="submit" name="action" value="Create"/>
            <input type="reset" value="Reset"/>
        </form>
        ${USER_ERROR.error}
    </body>
</html>
