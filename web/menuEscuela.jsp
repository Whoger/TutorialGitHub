
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = (String) session.getAttribute("username");
            if (username != null) {
                 %>
                 <h1>No hay usuario validado</h1>
                 <%
                }else{
                    %>
                    <h1>Hola Escuela <%=username%></h1>
                    
                    <form action="modificacionPerfil.jsp">
                        <input type="submit" value="Modificar Perfil" name="modificarPerfilSchools">
                    </form>
                    </br>
                    <form action="crearPartido.jsp">
                        <input type="submit" value="Crear Partido" name="crearPartido">
                    </form>
                    </br>
                    <form action="eliminarPartido.jsp">
                        <input type="submit" value="Eliminar Partido" name="eliminarPartido">
                    </form>
                    </br>
                    <form action="crearEquipo.jsp">
                        <input type="submit" value="Nueva Incidencia" name="crearEquipo"> 
                    </form>
                    <form action="deleteEquipo.jsp">
                        <input type="submit" value="Eliminar Equipo" name="eliminarEquipo"> 
                    </form>
                    <form action="deleteJugador.jsp">
                        <input type="submit" value="Eliminar Jugador" name="eliminarJugador"> 
                    </form>
                    <form action="deleteEntrenador">
                        <input type="submit" value="Eliminar Entrenador" name="eliminarEntrenador"> 
                    </form>
                    </br>
                    <form action="asignarEquipoJugador">
                        <input type="submit" value="Asignar Equipo Jugador" name="signarJugador"> 
                    </form>
                    </br>
                    <form action="asignarEquipoEntrenador">
                        <input type="submit" value="Asignar Equipo Entrenador" name="signarEntrenador"> 
                    </form>
                <% }
            
        
    }%>
    </body>
</html>