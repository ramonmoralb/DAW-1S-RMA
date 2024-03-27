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
    // Recojo el valor de matrícula
    String matricula = request.getParameter("matricula");
%>
<nav>
    <a href="index.html">Alta vaixells</a>
</nav>
<h1>Simulación del alquiler del barco <%=matricula %></h1>
<form method="post" action="calcularLloguer">
    <label for="nombre">Nombre: </label>
    <input type="text" name="nombre">
    <label for="dni">DNI:</label>
    <input type="text" name="dni" pattern="[0-9]{8}[A-Za-z]{1}" placeholder="12345678A">
    <label for="dias">Días de ocupación: </label>
    <input type="text" name="dias">
    <label for="posicion">Posición de amarre: </label>
    <input type="text" name="posicion">
    <input type="submit" value="Añadir">
    <input type="hidden" id="matricula" name="matricula" value="<%=matricula%>">
</form>
</body>
</html>