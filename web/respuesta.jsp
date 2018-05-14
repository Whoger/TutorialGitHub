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
        
        <a href="index.html">VOLVER</a>
    </body>
</html>
