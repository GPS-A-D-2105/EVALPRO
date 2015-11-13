<%-- 
    Document   : acerca
    Created on : 09-nov-2015, 21:05:12
    Author     : vrebo
--%>
<%@include file="variables.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${root}/css/principal.css" rel="stylesheet" />
        <link href="${root}/css/acerca.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div id="contenido">
            <h1>Acerca de...</h1>
            <p>
                Nuestra aplicación web está dirigida a toda aquella persona que necesita una base de
                conocimientos acerca de los profesores en el Instituto Tecnológico de Veracruz.
            </p>
            <p2>Nuestra idea surge  a raíz de la poca interacción con los maestros, es por esto que
                nosotros proponemos una herramienta sencilla y de gran importancia para todo aquel alumno
                que quiera seleccionar sus nuevas materias; la aplicación se alimenta de todas las reseñas y/o
                comentarios de alumnos más experimentados proporcionando así tips, consejos y sugerencias
                acerca de la forma de ser, calificar y dominio del tema que llega a tener un profesor.
            </p2>

            <p> La plataforma cuenta con moderadores los cuales se encargan diariamente de verificar, corregir y administrar todos los comentarios
                que sean ingresados a la plataforma. </p>

            <p>Ellos también son los encargados de eliminar algún comentario ofensivo si se 
                diera el caso, debido a que es una plataforma libre y cualquiera puede ingresar 
                comentarios. Los moderadores también tienen la capacidad de establecer reglas 
                en cuanto a la interacción de los usuarios, permitiendo que el entorno virtual sea un 
                ambiente sano y de convivencia para los usuarios.
            </p>

            <p2>
                Somos una empresa joven con gran potencial e ideas innovadoras, es por esto que 
                ponemos a disposición de todos nuestra herramienta, esperando que cada quien le 
                dé un buen uso y se retroalimente con comentarios positivos.
            </p2>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
