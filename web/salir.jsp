<%-- 
    Document   : salir
    Created on : 08/06/2018, 05:14:09 AM
    Author     : iFranco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saliendo</title>
    </head>
    <body>
        <%
        session.invalidate();
        response.sendRedirect("");
        %>
    </body>
</html>
