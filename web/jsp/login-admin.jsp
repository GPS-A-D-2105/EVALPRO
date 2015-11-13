<%-- 
    Document   : login-admin
    Created on : 11-nov-2015, 14:47:05
    Author     : vrebo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="variables.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title></title>
        <link href="${root}/css/login-admin.css" rel="stylesheet" />
    </head>
    <body><section id="creadores">
            <nav id="opciones_pagina">
                <a href="${root}">Inicio</a>
                <a href="${root}/jsp/acerca.jsp">Acerca</a>
                <a href="${root}/jsp/login-admin.jsp"> Administradores</a>
            </nav>
        </section>
       
        <section id="contenido"><section id="logo">
            <img src="../imagenes/EvalPro.png" />
        </section>
            <form action="${root}/login-admin" method="POST">
                <label for="user-id">USUARIO:</label>
                <input class="textfield" type="text" id="user-id" name="user"/>
                <label for="user-pass">CONTRASEÑA:</label>
                <input class="textfield" type="password" id="user-pass" name="pass"/>
                <br/><br/>
                <input class="button" type="button" value="REGISTRAR"/>
                <input class="button" type="submit" value="INICIAR"/>
            </form>
        </section>
    </body>
</html>
