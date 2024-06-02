<%-- 
    Document   : resultado
    Created on : 31 may 2024, 16:48:27
    Author     : Usuario
--%>

<%@page import="modelo.Figura"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>Taula de Figures Geomètriques</title>
    <script type="text/javascript" src="https://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=0ryIIPHOCrxGjOqXppyHw2EBp0HSWWgxYhPaObBs0ioIwcYnV2pcH6wxbDR4r5wkPyfrMAYSN8TvcaPGZFGz1FeH246IG7knPyIYXRT_pZwY8evFkxLMqaJZlu1QS4RUeNoAEj4cQfw7P-X3xZMmtsiU6t7NZ54sfLP0UxXpgPV3-ZLeY4KRNh9rFY_brbWa" charset="UTF-8"></script><link rel="stylesheet" crossorigin="anonymous" href="https://gc.kis.v2.scr.kaspersky-labs.com/E3E8934C-235A-4B0E-825A-35A08381A191/abn/main.css?attr=aHR0cHM6Ly9hdWxlcy5lZHUuZ3ZhLmVzL3NlbWlwcmVzZW5jaWFsL3BsdWdpbmZpbGUucGhwLzE3MjkwNDEvbW9kX2ZvbGRlci9jb250ZW50LzAvcmVzdWx0YXRzLmh0bWw_Zm9yY2Vkb3dubG9hZD0x"/><style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333333;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            background-color: #ffffff;
            border: 1px solid #dddddd;
            border-radius: 5px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
            text-transform: uppercase;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover :not(th){
            opacity: 70%;
        }
    </style>
</head>
<body>
    <% ArrayList<Figura> lista = (ArrayList<Figura>) request.getSession().getAttribute("listaFiguras");%>
    <h1>Taula de Figures Geomètriques</h1>
  <%if (lista!=null && !lista.isEmpty()){
            for(Figura f : lista){
            %>
    <table>
        <tr>
            <th>Figura</th>
            <th>Perímetre</th>
            <th>Àrea</th>
            <th>Color</th>
            <th>Calculate</th>
        </tr>
         
        <tr> 
            <td><%= f.toString()%></td>
            <td><%= f.getPerimetro() %></td>
            <td><%= f.getArea() %></td>
            <td style="background-color: <%= f.getColor() %>"></td>
            <td><a href="calculate.jsp?prueba=<%= f.getArea() %>">Pruebas de get</a></td>
        </tr>
        
      
    </table>
            <%}%>
            <%}else{%>
            <h2>La lsita esta vacia.</h2>
            <%}%>
</body>
</html>


