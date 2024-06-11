<%-- 
    Document   : mostrarLloguer
    Created on : 26 mar 2024, 1:24:29
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lloguervaixells.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
         String missatge = (String) request.getAttribute("missatge"); 
          if(missatge != null && missatge.equals("Simulación completada.")){
          Lloguer alquiler = (Lloguer) request.getAttribute("alquiler");  //atribute importante
          double precio = alquiler.getPreuLloguer();
          Vaixell vaixell = alquiler.getVaixell();
          double factor = vaixell.getFactor();   
        %>
        <p><strong>Mensaje  </strong><%= missatge %></p>
        <p><strong>Nombre del cliente  :  </strong><%= alquiler.getNomClient() %></p>
        <p><strong>DNI del cliente     :  </strong><%= alquiler.getDniClient() %></p>
        <p><strong>Dias de cocupación  :  </strong><%= alquiler.getDiesOcupacio() %></p>
        <p><strong>Posición del amarre :  </strong><%= alquiler.getPosicioAmarrament() %></p>
        <p><strong>Datos del barco     :  </strong>[<%= vaixell.toString() %>]</p>
        <p><strong>Total precio        :  </strong> <%= precio %> €</p>
        <br>
        <p><strong>Factor               :  </strong> <%= factor %> €</p>
        <a href="index.html">Volver al inicio.</a>
        <%}else{%>
        <p><strong>Algo a fallado</p>
        <a href="index.html">Volver al inicio.</a>
        <%}%>

    </body>
</html>