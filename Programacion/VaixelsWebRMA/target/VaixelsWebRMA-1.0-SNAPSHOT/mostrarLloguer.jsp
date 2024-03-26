<%-- 
    Document   : mostrarLloguer
    Created on : 26 mar 2024, 1:24:29
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lloguervaixells.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <% 
        Lloguer alquiler = (Lloguer) request.getAttribute("alquiler");  //atribute importante
        double precio = alquiler.getPreuLloguer();
    %>
    <h1>precio = <%= precio %></h1>
    </body>
</html>