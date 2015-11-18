<%-- 
    Document   : Materias.jsp
    Created on : 28-oct-2015, 17:08:03
    Author     : vrebo
--%>
<%@include file="variables.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("colors", new String[]{"tr2", "tr3", "tr4", "tr5", "tr1"}, pageContext.SESSION_SCOPE);
%>
<c:set var="i" value="${0}"/>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title></title>
        <link href="${root}/css/principal.css" rel="stylesheet" />
        <link href="${root}/css/materias.css" rel="stylesheet" />
        <link href="${root}/css/header.css" rel="stylesheet"/>
    </head>
    <body>
        <%@include file="header.jsp" %>

        <div id="contenedor">
            <h1>Materias</h1>
            <table >
                <tr id="tr1">
                    <td><article id="article1"><h3>NOMBRE</h3></article></td>
                    <td><article><h3>CREDITOS</h3></article></td>
                    <td><article><h3>CLAVE</h3></article></td>
                </tr>
                <c:forEach var="materia" items="${listaMaterias}">
                    <tr id="${colors[i]}">
                        <c:set var="enlace" value="${root}/profesor?idMateria=${materia.id}&nombreMateria=${materia.nombreMateria}"/>
                        <td><a href="${enlace}"><article id="article1"><p>${materia.nombreMateria}</p></article></a></td>
                        <td><a href="${enlace}"><article><p>${materia.creditos}</p></article></a></td>
                        <td><a href="${enlace}"><article><p>${materia.id}</p></article></a></td>
                    </tr>
                    <c:set var="i" value="${i+1}"/>
                    <c:if test="${i == 5}">
                        <c:set var="i" value="${0}"/>
                    </c:if>
                </c:forEach>
            </table>
        </div>
        <%@include file="footer.jsp" %>
        </div>
    </body>
</html>



