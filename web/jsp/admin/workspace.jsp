<%-- 
    Document   : workspace
    Created on : 19-nov-2015, 14:24:55
    Author     : vrebo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../variables.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${root}/css/principal.css" rel="stylesheet" />
        <link href="${root}/css/profesores.css" rel="stylesheet" />
        <link href="${root}/css/bienvenidoAdmin.css" rel="stylesheet" />
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

        <h1>Bienvenido Administrador</h1>
        <section id="contenido1">
            <section id="profesoresbusqueda">
                <section id="buscadormaestros">
                    <input type="search" id="search2" placeholder="buscar algun maestro en especifico" autocomplete="on"  />
                </section>
                <a> <p>Agregados Recientemente</p></a>
            </section>

            <section id="AEadmin">

                <h5>Administradores</h5>
                <section id="grupo">
                    <a href="${root}/admin/alta-admin"> <div><p>Agregar</p></div></a>
                    <a href="${root}/admin/gestion-admin"> <div><p>Eliminar</p></div></a>
                </section> 
            </section>
        </section>
        <table>
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

        </table>
        <%@include file="../footer.jsp" %>
    </body>
</html>
