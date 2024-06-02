<%-- 
    Document   : calculate
    Created on : 31 may 2024, 17:14:36
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        String color =  request.getParameter("prueba");
    %>
    <body>
        <h1>Hello World!</h1>
        <h2>color prueba =  <%=color%></h2> 
    </body>
</html>
