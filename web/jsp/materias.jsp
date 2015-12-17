<%-- 
    Document   : Materias.jsp
    Created on : 28-oct-2015, 17:08:03
    Author     : vrebo
--%>
<%@include file="variables.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("colors", new String[]{"green-s", "blue", "emerald", "pistache", "green"}, pageContext.SESSION_SCOPE);
%>
<c:set var="i" value="${0}"/>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title></title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link href="${css}/main.css" rel="stylesheet" />
        <link href="${css}/nav-bar.css" rel="stylesheet"/>
        <link href="${css}/materias.css" rel="stylesheet"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="nav-bar.jsp" %>
        <main>
            <h1>Materias</h1>
            <table id="materias">
                <tr class="green center">
                    <th class="materia">NOMBRE</th>
                    <th class="creditos">CREDITOS</th>
                    <th class="clave">CLAVE</th>
                </tr>
                <c:forEach var="materia" items="${listaMaterias}">
                    <tr class="${colors[i]}">
                        <c:set var="enlace" value="${root}/profesor?idMateria=${materia.idMateria}&nombreMateria=${materia.nombre}"/>
                        <td><a href="${enlace}">${materia.nombre}</a></td>
                        <td class="center"><a href="${enlace}">${materia.creditos}</a></td>
                        <td class="center"><a href="${enlace}">${materia.idMateria}</a></td>
                    </tr>
                    <c:set var="i" value="${i+1}"/>
                    <c:if test="${i == 5}">
                        <c:set var="i" value="${0}"/>
                    </c:if>
                </c:forEach>
            </table>
        </main>
        <%@include file="footer.jsp" %>
    </body>
</html>



