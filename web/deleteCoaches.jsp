<%-- 
    Document   : deleteCoaches
    Created on : 14-may-2018, 17:48:43
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
            List<String> coaches = (List<String>) request.getAttribute("coaches");

        %>
        <form action="DeleteCoachServlet" method="POST">
            <select name="seleccionarCoach">
                <%                       
                   for (String coa : coaches) {
                %>
                        <option> <%= coa%> </option>
                <%
                    }
                %>
            </select>

            <p><input type="submit" value="OK"></p>
        </form>

    </body>
</html>
