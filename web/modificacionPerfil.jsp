<%-- 
    Document   : modificacionPerfil
    Created on : 13-may-2018, 17:38:09
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
        <h1>Modificar perfil</h1>
        <form method="POST" action="ModificarPerfilServlet">
            <p>Nombre completo: <input type="text" name="fullName"  required></p>
            <p>Contraseña: <input type="text" name="password" required></p>
            
            <p><input type="submit" value="Modificar"></p>
        </form>
    </body>
</html>
