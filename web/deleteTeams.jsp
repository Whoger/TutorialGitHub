<%-- 
    Document   : deleteTeams
    Created on : 14-may-2018, 17:48:36
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
            List<String> teams = (List<String>) request.getAttribute("teams");

        %>
        <form action="DeleteTeamServlet" method="POST">
            <select name="seleccionarTeam">
                <%                       
                   for (String tea : teams) {
                %>
                        <option> <%= tea%> </option>
                <%
                    }
                %>
            </select>

            <p><input type="submit" value="OK"></p>
        </form>

    </body>
</html>