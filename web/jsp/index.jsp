<%-- 
    Document   : Index
    Created on : 28-oct-2015, 11:04:09
    Author     : vrebo
--%>
<%@include file="variables.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>EvalPro</title>
        <link href="${root}/css/principal.css" rel="stylesheet" />
        <link href="${root}/css/inicio.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div id="contenido">
            <h1>Bienvenida</h1>
            <p>
                Bienvenido a esta página, donde  podrás evaluar  a tus profesores en
                cuanto a tu experiencia escolar dentro del Instituto Tecnológico de Veracruz.
                Los criterios que podras evaluar  de tus profesores son los siguientes:
            </p>
            <dl>
                <dt>1.Asistencia</dt>
                <dt>2.Dominio del tema</dt>
                <dt>3.Calidad de enseñanza</dt>
            </dl>

            <p> Ten en cuenta que deberás conservar un lenguaje apropiado para realizar tus comentarios.</p>

            <h2>Como usar la pagina</h2>

            <div id="panel">
                <img src="imagenes/Sin título.png" width="700" height="500" />
            </div>
        </div>

        <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
