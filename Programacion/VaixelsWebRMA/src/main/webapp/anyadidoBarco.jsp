<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lloguervaixells.*"%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
       <% String missatge = (String) session.getAttribute("missatge"); %>
         <h1>aqui el mensaje</h1>
         <p><%= missatge %></p>
        <a href="llistaVaixells.jsp">Continuar</a>
    </body>
</html>
