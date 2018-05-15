<%-- 
    Document   : listadoEntrenadores
    Created on : 14-may-2018, 20:08:10
    Author     : JOSEP Mª
--%>

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
                <th>Nombre completo</th><th>Nombre usuario</th><th>Pais</th>
            </tr>

            <%
                List<Schools> listaEquipos = (List<Schools>) request.getAttribute("listaEquipos");
                for (Schools i : listaEquipos) {
            %>

            <tr>
                <td><%= i.getFullName()%></td>
                <td><%= i.getUsername()%></td> 
                <td><%= i.getCountry()%></td>

            </tr>

            <% }%>
        </table><br>    </body>
</html>
