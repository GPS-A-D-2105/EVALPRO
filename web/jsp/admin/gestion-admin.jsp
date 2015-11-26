<%-- 
    Document   : gestion-admin
    Created on : 19-nov-2015, 14:43:20
    Author     : vrebo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../variables.jsp" %>
<%
    pageContext.setAttribute("colors", new String[]{"tr1", "tr2", "tr3", "tr4", "tr5"}, pageContext.SESSION_SCOPE);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${root}/css/principal.css" rel="stylesheet" />
        <link href="${root}/css/eliminarAdmin.css" rel="stylesheet" />
        <link href="${root}/css/header.css" rel="stylesheet" />
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
                    <li><a href="#">...</a></li>
                </ul>
            </nav>
        </section>


        <h1>Lista de Administradores </h1>
        <table>
            <c:forEach var="admin" items="${listaAdmins}">
                <tr id="${colors[i]}">
                    <td>
                        <c:set var="nombreAdmin" value="${admin.nombreAdmin} ${admin.apePaterno} ${admin.apeMaterno}"/>
                        <a href="${root}/baja-admin?id=${admin.id}">
                            <article><p>${nombreAdmin}</p> 
                                <img src="${root}/imagenes/trash.png" alt="Eliminar"/>
                            </article></a>
                    </td>
                </tr>
                <c:set var="i" value="${i+1}"/>
                <c:if test="${i == 5}">
                    <c:set var="i" value="${0}"/>
                </c:if>
            </c:forEach>
        </table>

    </body>
</html>
