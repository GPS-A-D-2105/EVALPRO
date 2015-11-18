<%-- 
    Document   : header
    Created on : 09-nov-2015, 21:01:13
    Author     : vrebo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<div id="contenedor">
    <div id="header">
        <section id="compañia">
            <img src="${root}/imagenes/EvalPro.png" width="180" height="45" />
            <p id="eslogan">aqui va un slogan</p>
        </section>
        <section id="creadores">
            <nav id="opciones_pagina">
                <a href="${root}">Inicio</a>
                <a href="${root}/acerca">Acerca</a>
                <a href="${root}/jsp/login-admin.jsp">Administradores</a>
            </nav>
            <section id="buscador">
                <input type="search" id="search" placeholder="buscar..." autocomplete="on" border="1" />
            </section>
        </section>
    </div>
    <div id="menu">
        <nav>
            <a href="${root}/">Inicio</a>
            <a href="${root}/carrera">Carrera</a>
            <a href="${root}/materia">Materias</a>
            <a href="${root}/profesor">Profesores</a>
            <a href="${root}/mas">...</a>
        </nav>
    </div>
</div>-->
<section>
<section id="header">
    <div id="logo-eslogan">
        <img id="logo" src="${root}/imagenes/EvalPro.png" />
        <h4>Aquí va un eslogan.</h4>
    </div>
    <nav class="nav-bar-2">
        <ul>
            <li><a href="${root}">INICIO</a></li>
            <li><a href="${root}/acerca">ACERCA</a></li>
            <li><a href="${root}/materia">ADMINISTRADOR</a></li>                            
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