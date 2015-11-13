<%-- 
    Document   : formulario
    Created on : 12-nov-2015, 22:01:28
    Author     : vrebo
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
        <form action="/evalpro/TestServlet">
            <label>USUARIO:</label>
            <input type="text" name="username" autofocus="true" autocomplete="true"/>
            <label>CONTRASEÑA:</label>
            <input type="password" name="password" />
            <input type="submit"/>
        </form>
    </body>
</html>
