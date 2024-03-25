<%-- 
    Document   : llistaVaixels
    Created on : 23 mar 2024, 7:59:24
    Author     : Usuario
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lloguervaixells.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListaVaixells</title>
    </head>
    <body>
        <% //si entra al if de calcular lloguer debe mostrar el mensaje de error al ser redireccionado
            String error = (String) request.getAttribute("error");
            if (error != null && !error.isEmpty()) {
        %>
        <div >
            <%= error%>
        </div>
        <%
            }// establecer el formato que pide la practica
        %>

        <h1>Lista de barcos</h1>
        <table>

            <tr>
                <th>Tipo</th>
                <th>Matrícula</th>
                <th>Eslora</th>
                <th>Año Fab.</th>
                <th>Potencia</th>
                <th>Cabinas</th>
                <th>Mástiles</th>
                <th>Opciones</th>
            </tr>
            <tbody>
                <tr>

                    <%  ArrayList<Vaixell> vaixels = (ArrayList<Vaixell>) session.getAttribute("vaixels"); %> <%-- pendiente de definir pero funciona--%>

                    <%for (Vaixell vaixell : vaixels) {
                            //añadir todos los casos

                            if (vaixell instanceof Veler) {
                                out.print("<tr>");

                                out.print("<td>Veler</td>");
                                out.print("<td>" + vaixell.getMatricula() + "</td>");
                                out.print("<td>" + vaixell.getEslora() + "</td>");
                                out.print("<td>" + vaixell.getAnyFabricacio() + "</td>");
                                out.print("<td>-</td>");
                                out.print("<td>-</td>");
                                out.print("<td>" + ((Veler) vaixell).getNombreMastelers() + "</td>");
                                out.println("<td><a href=\"simulador.jsp?matricula=" + vaixell.getMatricula() + "\">Simular alquiler</a></td>"); //em el enlace paso por parametroGet
                                out.print("</tr>");
                            } else if (vaixell instanceof Iot) {
                                out.print("<tr>");
                                out.print("<td>Iot</td>");
                                out.print("<td>" + vaixell.getMatricula() + "</td>");
                                out.print("<td>" + vaixell.getEslora() + "</td>");
                                out.print("<td>" + vaixell.getAnyFabricacio() + "</td>");
                                out.print("<td>" + ((Iot) vaixell).getPotencia() + "</td>");
                                out.print("<td>" + ((Iot) vaixell).getNombreCabines() + "</td>");
                                out.print("<td>-</td>");
                                out.println("<td><a href=\"simulador.jsp?matricula=" + vaixell.getMatricula() + "\">Simular alquiler</a></td>");
                                out.print("</tr>");
                            } else if (vaixell instanceof Esportiu) {
                                out.print("<tr>");
                                out.print("<td>Esportiu</td>");
                                out.print("<td>" + vaixell.getMatricula() + "</td>");
                                out.print("<td>" + vaixell.getEslora() + "</td>");
                                out.print("<td>" + vaixell.getAnyFabricacio() + "</td>");
                                out.print("<td>" + ((Esportiu) vaixell).getPotencia() + "</td>");
                                out.print("<td>-</td>");
                                out.print("<td>-</td>");
                                out.println("<td><a href=\"simulador.jsp?matricula=" + vaixell.getMatricula() + "\">Simular alquiler</a></td>");
                                out.print("</tr>");
                            }

                        }%>
                </tr>    
            </tbody>
        </table>
    </body>
</html>
