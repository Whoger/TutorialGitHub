<%-- 
    Document   : deletePlayers
    Created on : 14-may-2018, 17:48:25
    Author     : JOSEP Mª
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<String> players = (List<String>) request.getAttribute("players");

        %>
        <form action="DeletePlayerServlet" method="POST">
            <select name="seleccionarPlayer">
                <%                       
                   for (String pla : players) {
                %>
                        <option> <%= pla%> </option>
                <%
                    }
                %>
            </select>

            <p><input type="submit" value="OK"></p>
        </form>

    </body>
</html>