<%-- 
    Document   : alta-admin
    Created on : 18-nov-2015, 3:55:44
    Author     : vrebo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../variables.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link href="${css}/main.css" rel="stylesheet"/>
        <link href="${css}/nav-bar.css" rel="stylesheet"/>
        <link href="${css}/registro-admin.css" rel="stylesheet"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>   
        <title>EvalPro - Alta administrador</title>
    </head>
    <body>
        <%@include file="../nav-bar.jsp"%>
        <div id="form-alta-admin">
            <header>
                <h1>ALTA DE ADMINISTRADORES</h1>
            </header>
            <form action="${admin}/alta-admin" method="POST">
                <table>
<!--                    <tr>
                        <td class="label"><label>NOMBRE DE USUARIO:</label></td>
                        <td><input name="nombre-usuario" type="text" required/></td>
                    </tr>-->
                    <tr>
                        <td class="label"><label>NUMERO DE CONTROL:</label></td>
                        <td><input name="no-control" type="text" required/></td>
                    </tr>
                    <tr>
                        <td class="label"><label>NOMBRE:</label></td>
                        <td><input name="nombre" type="text" required/></td>
                    </tr>
                    <tr>
                        <td class="label"><label>APELLIDO PATERNO:</label></td>
                        <td><input name="ap-paterno" type="text" required/></td>
                    </tr>
                    <tr>
                        <td class="label"><label>APELLIDO MATERNO:</label></td>
                        <td><input name="ap-materno" type="text" required/></td>
                    </tr>
                    <tr>
                        <td class="label"><label>CORREO ELECTRÓNICO:</label></td>
                        <td><input  name="email" type="email" required/></td>
                    </tr>
                    <tr>
                        <td class="label"><label>CONTRASEÑA:</label></td>
                        <td><input name="password" type="text" required/></td>
                    </tr>                    
                </table>
                <input type="submit" value="REGISTRAR"/>
            </form>
        </div>
        
        <%@include file="../footer.jsp" %>
    </body>
</html>
