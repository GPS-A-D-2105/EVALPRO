<%-- 
    Document   : MozaicoCarreras
    Created on : 28-oct-2015, 10:48:35
    Author     : vrebo
--%>
<%@include file="variables.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("colors", new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i"}, pageContext.SESSION_SCOPE);
%>
<c:set var="i" value="${0}"/>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title></title>
        <link href="${root}/css/principal.css" rel="stylesheet" />
        <link href="${root}/css/carreras.css" rel="stylesheet" />
        <link href="${root}/css/header.css" rel="stylesheet"/>
    </head>
    <body>
        <%@include file="header.jsp" %>

        <div id="contenidoimg">
            <h1>Selecciona una carrera</h1>
            <section id="carreras">
                <c:forEach var="carrera" items="${listaCarreras}">
                    <a href="${root}/materia?idCarrera=${carrera.idCarrera}">
                        <article class="${colors[i]}">                            
                            <h3>${carrera.nombreCarrera}</h3>
                            <img src="${root}/${carrera.iconoUrl}" width="92" height="100"/>
                        </article>
                    </a>
                    <c:set var="i" value="${i+1}"/>
                    <c:if test="${i == 9}">
                        <c:set var="i" value="${0}"/>
                    </c:if>
                </c:forEach>
            </section>
        </div>
        <%@include file="footer.jsp" %>       
    </body>
</html>

