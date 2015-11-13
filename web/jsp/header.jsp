<%-- 
    Document   : header
    Created on : 09-nov-2015, 21:01:13
    Author     : vrebo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="contenedor">
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