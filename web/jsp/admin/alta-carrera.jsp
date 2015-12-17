<%-- 
    Document   : alta-carrera
    Created on : 1/12/2015, 12:04:12 AM
    Author     : Alfonso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../variables.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Alta de carreras</title>
        <script src="${root}/js/agregarCarrera.js"></script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link href="${css}/main.css" rel="stylesheet" />
        <link href="${css}/nav-bar.css" rel="stylesheet" />
        <link href="${css}/agregarCarrera.css" rel="stylesheet" />        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    </head>
    <body>
        <%@include file="../nav-bar.jsp" %>
        <div id="contenedor">
            <div id="contenido">
                <h1>Agregar Carrera</h1>
                <div id="color">
                    <form action="${root}/admin/publicar-carrera" method="POST">
                        <p>Nombre de la carrera</p>
                        <input type="text" name="nombre-carrera" required />
                        <p id="bonito">Establecer un icono para la carreara</p>
                        <div id="caja"></div>
                        <input id="boton" type="submit" value="AGREGAR" />
                    </form>
                </div>
            </div>
        </div>
        <%@include file="../footer.jsp" %>
    </body>
</html>

