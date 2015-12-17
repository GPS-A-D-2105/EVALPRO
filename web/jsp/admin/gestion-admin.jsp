<%-- 
    Document   : gestion-admin
    Created on : 19-nov-2015, 14:43:20
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
        <title>JSP Page</title>
        <!--<link href="${root}/css/principal.css" rel="stylesheet" />-->
        <!--<link href="${root}/css/header.css" rel="stylesheet" />-->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link href="${css}/main.css" rel="stylesheet" />
        <link href="${css}/nav-bar.css" rel="stylesheet" />
        <!--<link href="${css}/agregarCarrera.css" rel="stylesheet" />-->       
        <link href="${root}/css/eliminarAdmin.css" rel="stylesheet" />
        <link href="${css}/profesores.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <style>
            table{
                color:white;
            }
        </style>
    </head>
    <body>
        <%@include file="../nav-bar.jsp" %>
        <h1>Lista de Administradores </h1>
        <table id="profesores">
            <c:forEach var="administrador" items="${listaAdmins}">
                <tr class="${colors[i]}">
                    <td>
                        <c:set var="nombreAdmin" value="${administrador.nombre} ${administrador.apellidoPaterno} ${administrador.apellidoMaterno}"/>
                        <article>
                            <p>${nombreAdmin}</p>
                        </article>

                    </td>
                    <td>
                        <a href="${admin}/baja-admin?id=${administrador.idAdmin}">
                            <img src="${root}/imagenes/trash.png" alt="Eliminar"/>
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
