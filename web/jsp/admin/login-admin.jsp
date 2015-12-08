<%-- 
    Document   : login-admin
    Created on : 11-nov-2015, 14:47:05
    Author     : vrebo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../variables.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title></title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        <!--<link href="prueba.css" rel="stylesheet"/>-->
        <!--<link href="${root}/css/login-admin.css" rel="stylesheet" />-->
        <link href="${root}/css/header.css" rel="stylesheet"/>
        <link href="${root}/css/formulario.css" rel="stylesheet"/>
        <style>
            body{
                margin: auto;
                width: 80%;
                background-color: #0B9444;
            }
            nav{
                float: top;
                text-align: right;
            }
        </style>
    </head>
    <body>
        <nav id="opciones_pagina">            
            <a href="${root}">Inicio</a>
            <a href="${root}/jsp/acerca.jsp">Acerca</a>
            <!--<a href="${root}/jsp/login-admin.jsp"> Administradores</a>-->
        </nav>
        <div id="login">
            <img src="${root}/imagenes/EvalPro.png" alt="Evalpro"/>            
            <form class="form-horizontal" role="form" action="j_security_check" method="POST">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="j_username">USUARIO:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="j_username" placeholder="Ingresa tu username" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="j_password">CONTRASEÑA:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="j_password" placeholder="Ingresa tu contraseña" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10">
                        <input type="submit" class="btn btn-primary" value="ENTRAR"/>
                    </div>
                </div>

                <a href="#">¿Olvidaste tu contraseña?</a>
            </form>
        </div>
        </section>
    </body>
</html>
