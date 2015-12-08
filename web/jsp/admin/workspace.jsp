<%-- 
    Document   : workspace
    Created on : 19-nov-2015, 14:24:55
    Author     : vrebo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../variables.jsp" %>
<%
    pageContext.setAttribute("colors", new String[]{"green", "blue", "aqua", "pistache", "lima"}, pageContext.SESSION_SCOPE);
%>
<c:set var="i" value="${0}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Admin</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link href="${css}/main.css" rel="stylesheet" />
        <link href="${css}/nav-bar.css" rel="stylesheet" />        
        <link href="${css}/bienvenidoAdmin.css" rel="stylesheet" />
        <link href="${css}/profesores.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <style>
            table{
                text-transform: uppercase;
            }
            h1{
                color: #2BB673;
            }
        </style>
    </head>
    <body>
        <%@include file="../nav-bar.jsp" %>
        <h1>Bienvenido Administrador</h1>
        <section id="contenido1">
            <section id="profesoresbusqueda">
                <section id="buscadormaestros">
                    <input type="search" id="search2" placeholder="buscar algun maestro en especifico" autocomplete="on"  />
                </section>
                <a href="${root}/admin/gestion-comentarios"> <p>Agregados Recientemente</p></a>
            </section>

            <section id="AEadmin">
                <h5>Administradores</h5>
                <section id="grupo">
                    <a href="${admin}/alta-admin"> <div><p>Agregar</p></div></a>
                    <a href="${admin}/gestion-admin"> <div><p>Eliminar</p></div></a>
                </section> 
            </section>
        </section>

        <table id="profesores">
            <c:forEach var="profesor" items="${profesores}">
                <tr class="${colors[i]}">
                    <td>
                        <c:set var="nombreProfesor" value="${profesor.nombre} ${profesor.apellidoPaterno} ${profesor.apellidoMaterno}"/>
                        <a href="${root}/admin/revisar-comentarios-prof?idMaestro=${profesor.idMaestro}">
                            <article>
                                <p>${nombreProfesor}</p>
                            </article>
                        </a>
                    </td>
                </tr> 
                <c:set var="i" value="${i+1}"/>
                <c:if test="${i == 5}">
                    <c:set var="i" value="${0}"/>
                </c:if>
            </c:forEach>
        </table>
        <%@include file="../footer.jsp" %>
    </body>
</html>
