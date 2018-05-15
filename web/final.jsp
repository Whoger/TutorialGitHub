<%-- 
    Document   : final.jsp
    Created on : 14-may-2018, 13:00:23
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
          String status = (String) request.getAttribute("status");
          if (status != null){
              %>
              <h1><%= status%></h1>
              <%
          }
        %> 
        
    </body>
</html>
