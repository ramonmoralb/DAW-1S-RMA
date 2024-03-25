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
            // recojo el valor de matricula
            String matricula = request.getParameter("matricula");
           // session.setAttribute("matricula", matricula);  //no necesario el formulario le pasa el valor al servlet
        %>
        <nav>
            <a href="index.html">Alta vaixells</a>
        </nav>
        <h1>Simulación del alquiler del barco <%=matricula %></h1>
        <form method="post" action="calcularLloguer">
            <label for="nombre">Nombre: </label>
            <input type="text" name="nombre">
            <label for="dni">DNI:</label>
            <input type="text" name="dni">
            <label for="dias" >Días de ocupación: </label>
            <input type="text" name="dias">
            <label for="posicion" >Posición de amarre: </label>
            <input type="text" name="posicion">
            <input type="submit" value="añadir">
            <input type="hidden" id="matricula" name="matricula" value="<%=matricula%>">
        </form>
    </body>
</html>
