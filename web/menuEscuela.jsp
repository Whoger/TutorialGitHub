<%-- 
    Document   : menuEscuela
    Created on : 12-may-2018, 13:22:34
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
        <%
            String user = (String) session.getAttribute("user");
        %>
        <h1>Menú Escuela <%= user%></h1>


        <form action="SeleccionarEmpleado">
            <input type="submit" value="Crear Partido" name="crearPartido">
        </form>

        <form action="SeleccionarEmpleado">
            <input type="submit" value="Borrar usuario" name="borrarUsuario">
        </form>

    </body>
</html>
