<%-- 
    Document   : nuevos-coments
    Created on : 26/11/2015, 01:48:29 AM
    Author     : Alfonso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../variables.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${root}/css/principal.css" rel="stylesheet" />
        <link href="${root}/css/caja-comentarios.css" rel="stylesheet"/>
        <link href="${root}/css/header.css" rel="stylesheet"/>
        <style>
            h1{
                color: #2BB673;
                text-align: center;
                margin: 30px;
                font-weight: bold;
                font-size: 38px;
            }
            div#cmnt-box{
                margin: auto;
                max-width: 80%;
                width: 80%;
            }
            td.date{
                text-align: left;
            }
            .remitente{
                text-align: left;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <section>
            <section id="header">
                <div id="logo-eslogan">
                    <img id="logo" src="${root}/imagenes/EvalPro.png" alt="Evalpro logo"/>
                    <h4>Aquí va un eslogan.</h4>
                </div>
                <nav class="nav-bar-2">
                    <ul>
                        <li><a href="${root}">INICIO</a></li>
                        <li><a href="${root}/acerca">ACERCA</a></li>
                        <li><a href="${root}">CERRAR SESIÓN</a></li>                            
                    </ul>
                    <form>
                        <input type="search" placeholder="Buscar..." style="margin: 20px; width: 260px;">
                    </form>
                </nav>
            </section>
            <nav class="nav-bar">
                <ul>
                    <li><a href="${root}">INICIO</a></li>
                    <li><a href="${root}/carrera">CARRERAS</a></li>
                    <li><a href="${root}/materia">MATERIAS</a></li>
                    <li><a href="${root}/profesor">PROFESORES</a></li>
                    <li><a href="${root}/admin">ADMIN</a></li>
                </ul>
            </nav>
        </section>
        <h1>Comentarios agregados recientemente</h1>
        <div id="cmnt-box">
            <!--Cabecera de la caja de comentarios-->
            <header>
                <h2>COMENTARIOS</h2>
            </header>
            <!--Sección para los comentarios-->
            <section id="section-cmnts">
                <c:forEach var="comentario" items="${comentarios}">
                    <article class="comment">
                        <table>
                            <tr>
                                <!--<td class="user">PROFESOR X</td>-->
                                <td class="date">${comentario.registro}</td>
                                <td>
                                    <a href="${root}/admin/revisar-comentarios?idComentario=${comentario.idComentario}&estado=aprobado" >
                                        <img src="${root}/imagenes/approve.jpg"/> 
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="content" >
                                    ${comentario.contenido}
                                </td>
                                <td>
                                    <a href="${root}/admin/revisar-comentarios?idComentario=${comentario.idComentario}&estado=censurado" >
                                        <img src="${root}/imagenes/delete.jpg"/>
                                    </a> 
                                </td>
                            </tr>
                            <tr>
                                <td class="remitente" colspan="2">
                                    <span>REMITENTE: </span>${comentario.usuario}
                                </td>
                            </tr>
                        </table>
                    </article>
                </c:forEach>
            </section>
        </div>
        <%@include file="../footer.jsp" %>
    </body>
</html>
