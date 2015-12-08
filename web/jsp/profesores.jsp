<%-- 
    Document   : profesores
    Created on : 13-nov-2015, 14:18:19
    Author     : vrebo
--%>

<%@include file="variables.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("colors", new String[]{"green", "blue", "aqua", "pistache", "lima"}, pageContext.SESSION_SCOPE);
%>
<c:set var="i" value="${0}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EvalPro - Profesores</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link href="${css}/main.css" rel="stylesheet" />
        <link href="${css}/nav-bar.css" rel="stylesheet"/>
        <link href="${css}/profesores.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>       
    </head>
    <body>
        <%@include file="nav-bar.jsp" %>
        <main>
            <c:choose>
                <c:when test="${tipoConsulta == 1}">
                    <h1>Profesores que imparten ${nombreMateria}</h1>
                </c:when>
                <c:otherwise>
                    <h1>Lista de todos los Profesores </h1>
                </c:otherwise>
            </c:choose>
            <table id="profesores">
                <c:forEach var="maestro" items="${listaMaestros}">
                    <tr class="${colors[i]}">
                        <td>
                            <c:set var="nombreProfesor" 
                                   value="${maestro.nombre} ${maestro.apellidoPaterno} ${maestro.apellidoMaterno}"/>
                            <a href="${root}/profesor-info?id=${maestro.idMaestro}&nombre=${nombreProfesor}">
                                ${nombreProfesor}
                            </a>
                        </td>
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
