<%-- 
    Document   : MozaicoCarreras
    Created on : 28-oct-2015, 10:48:35
    Author     : vrebo
--%>
<%@include file="variables.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("colors",
            new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i"},
            pageContext.SESSION_SCOPE);
%>
<c:set var="i" value="${0}"/>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>EvalPro - Carreras</title>       
        <link rel="stylesheet" 
              href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link href="${css}/main.css" rel="stylesheet" />
        <link href="${css}/nav-bar.css" rel="stylesheet"/> 
        <link href="${css}/carreras.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="nav-bar.jsp" %>
        <main>
            <h1>Selecciona una carrera</h1>
            <table id="carreras">
                <c:forEach var="carrera" items="${listaCarreras}">
                    <tr class="${colors[i]}">
                        <c:set var="enlace" value="${root}/materia?idCarrera=${carrera.idCarrera}"/>
                        <td>
                            <a href="${enlace}">
                                    ${carrera.nombre}
                            </a>
                        </td>
                        <td>
                            <a href="${enlace}">
                                <img src="${images}/${carrera.iconoUrl}" width="92" height="100"/>
                            </a>
                        </td>
                    </tr>
                    <c:set var="i" value="${i+1}"/>
                    <c:if test="${i == 9}">
                        <c:set var="i" value="${0}"/>
                    </c:if>
                </c:forEach>
            </table>
        </main>
        <%@include file="footer.jsp" %>       
    </body>
</html>

