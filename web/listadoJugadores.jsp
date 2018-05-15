<%-- 
    Document   : listadoJugadores
    Created on : 14-may-2018, 20:07:58
    Author     : JOSEP Mª
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Players"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista equipos</h1>
        <table>
            <tr>
                <th>Nombre completo</th>
                <th>Nombre usuario</th>
                <th>Posicion</th>
                <th>Fecha Nacimiento</th>
                <th>Lugar Nacimient</th>
                <th>Escoba</th>
                <th>Hijo de muggle?</th>
            </tr>

            <%
                List<Players> listaJugadores = (List<Players>) request.getAttribute("listaJugadores");
                for (Players i : listaJugadores) {
            %>

            <tr>
                <td><%= i.getFullName()%></td>
                <td><%= i.getUsername()%></td> 
                <td><%= i.getPosition()%></td>
                <td><%= i.getBirthPlace()%></td>
                <td><%= i.getBroomStick()%></td> 
                <td><%= i.getChildFromMuggle()%></td>


            </tr>

            <% }%>
        </table><br>
    </body>
</html>
