<%-- 
    Document   : alta-admin-confirmacion
    Created on : 19-nov-2015, 14:36:16
    Author     : vrebo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../variables.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${root}/css/ingresoOpcion.css" rel="stylesheet" />
    </head>
    <body>
        <section id="contenido">
            <section id="logo">
                <img src="${root}/imagenes/EvalPro.png" alt="Evalpro logo"/>
            </section>
            <section id="comentario">

                <h1>
                    Administrador agregado 
                </h1>

                <h2>correctamente </h2>

            </section>

            <section id="botones">

                <a href="${root}/alta-admin">
                    <article id="boton1">
                        <p>Seguir Agregando</p>
                    </article>
                </a>
                <a href="${root}/jsp/admin/workspace.jsp">
                    <article id="b">
                        <p>Salir</p>
                    </article>
                </a>

            </section>
        </section>
    </body>
</html>
