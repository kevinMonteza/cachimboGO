<%-- 
    Document   : ingresar
    Created on : 08/06/2018, 04:58:42 AM
    Author     : iFranco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="Controller" method="post">
            <input type="hidden" name="instruccion" value="login"/>
            <input type="text" name="uname" placeholder="Usuario"><br><br>
            <input type="password" name="upass" placeholder="Contrasena"><br><br>
            <input type="submit" value="Login">
        </form>        
    </body>
</html>
