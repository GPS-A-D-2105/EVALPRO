<%-- 
    Document   : profesores
    Created on : 13-nov-2015, 14:18:19
    Author     : vrebo
--%>

<%@include file="variables.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("colors", new String[]{"tr1", "tr2", "tr3", "tr4", "tr5"}, pageContext.SESSION_SCOPE);
%>
<c:set var="i" value="${0}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${root}/css/principal.css" rel="stylesheet" />
        <link href="${root}/css/profesores.css" rel="stylesheet" />
        <link href="${root}/css/header.css" rel="stylesheet"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <c:choose>
            <c:when test="${tipoConsulta == 1}">
                <h1>Profesores que imparten ${nombreMateria}</h1>
            </c:when>
            <c:otherwise>
                <h1>Lista de todos los Profesores </h1>
            </c:otherwise>
        </c:choose>
        <table>
            <c:forEach var="maestro" items="${listaMaestros}">
                <tr id="${colors[i]}">
                    <td>
                        <c:set var="nombreProfesor" value="${maestro.nombre} ${maestro.apellidoPaterno} ${maestro.apellidoMaterno}"/>
                        <a href="${root}/profesor-info?id=${maestro.idMaestro}&nombre=${nombreProfesor}">
                            <article><p>${nombreProfesor}</p></article>
                        </a>
                    </td>
                </tr>
                <c:set var="i" value="${i+1}"/>
                <c:if test="${i == 5}">
                    <c:set var="i" value="${0}"/>
                </c:if>
            </c:forEach>
        </table>



        <!--        <table  >
                    <tr id="tr1">
                        <td><a href="ProfesoresxMateria.html"><article><p>ANDRADE GOMEZ HECTOR ADOLFO</p></article></a></td>
                    </tr>
                    <tr id="tr2">
                        <td><a href="ProfesoresxMateria.html"><article><p>  CAMILO COSS DELIO</p></article></a></td>
                    </tr>
                    <tr id="tr3">
                        <td><a href="ProfesoresxMateria.html"><article><p> JUAREZ TINOCO SENEN</p></article></a></td>
        
                    </tr>
                    <tr id="tr4">
                        <td><a href="ProfesoresxMateria.html"><article><p> NOLASCO MATA MARIA DEL CARMEN</p></article></a></td>
        
                    </tr>
                    <tr id="tr5">
                        <td><a href="ProfesoresxMateria.html"><article><p>  LEZAMA HERNANDEZ LEONARDO</p></article></a></td>
        
                    </tr>
        
                    <tr id="tr1">
                        <td><a href="ProfesoresxMateria.html"><article><p>ANDRADE GOMEZ HECTOR ADOLFO</p></article></a></td>
        
                    </tr>
                    <tr id="tr2">
                        <td><a href="ProfesoresxMateria.html"><article><p>  CAMILO COSS DELIO</p></article></a></td>
        
                    </tr>
                    <tr id="tr3">
                        <td><a href="ProfesoresxMateria.html"><article><p> JUAREZ TINOCO SENEN</p></article></a></td>
        
                    </tr>
                    <tr id="tr4">
                        <td><a href="ProfesoresxMateria.html"><article><p> NOLASCO MATA MARIA DEL CARMEN</p></article></a></td>
        
                    </tr>
                    <tr id="tr5">
                        <td><a href="ProfesoresxMateria.html"><article><p>  LEZAMA HERNANDEZ LEONARDO</p></article></a></td>
        
                    </tr>
                </table>-->
        <%@include file="footer.jsp" %>
    </body>
</html>
