<%-- 
    Document   : index
    Created on : 24/11/2017, 19:04:01
    Author     : ligia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
    <% String tags = request.getParameter("tags"); %>
        <div>Token recebido via POST: <%=tags%></div>
</html>
