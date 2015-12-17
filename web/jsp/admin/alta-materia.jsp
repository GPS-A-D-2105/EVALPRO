<%-- 
    Document   : alta-materia
    Created on : 1/12/2015, 11:22:54 AM
    Author     : Alfonso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../variables.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title></title>
        <!--<link href="${root}/css/principal.css" rel="stylesheet" />-->
        <!--<link href="${root}/css/inicio.css" rel="stylesheet" />-->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link href="${css}/main.css" rel="stylesheet" />
        <link href="${css}/nav-bar.css" rel="stylesheet" />
        <link href="${css}/agregarMateria.css" rel="stylesheet" />    
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>

    <body>
        <%@include file="../nav-bar.jsp" %>
        <div id="contenedor">
            <div id="contenido">
                <h1>Agregar Materia</h1>
                <form action="${admin}/publicar-materia" method="POST">
                    <div id="color">
                        <table>
                            <tr>
                                <td>Nombre:</td>
                                <td><input type="text" name="nombre-materia" required /></td>
                            </tr>
<!--                            <tr>
                                <td>Clave:</td>
                                <td><input type="text" name="clave" required /></td>
                            </tr>-->
                            <tr>
                                <td>Creditos:</td>
                                <td><input type="text" name="creditos" required /></td>
                            </tr>
                        </table>
                        <input id="boton" type="submit" value="AGREGAR" />
                    </div>
                </form>




            </div>



            <footer>
                <p>© Copyright Gestion de proyectos 2015 -</p>
            </footer>
        </div>
    </body>
</html>
