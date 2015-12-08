<%-- 
    Document   : header
    Created on : 1/12/2015, 03:02:30 PM
    Author     : Alfonso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="nav-bar">
    <div class="container-fluid" id="header">
        <div class="row" id="top">
            <div class="col-md-3 logo" style="float: left;">
                <div class="center">
                    <img src="${images}/EvalPro.png" alt="EVALPRO" />
                    <p>Aquí va un Slogan</p>
                </div>
            </div>
            <div class="col-md-4" style="float: right;">
                <table style="height: 30px; text-align: center;">
                    <tr>
                        <td style="padding-bottom: 10px;">
                            <a href="${root}/acerca">ACERCA</a>
                            <c:choose>
                                <c:when test="${isAdmin == 1}">
                                    <a href="${admin}/logout">CERRAR SESIÓN</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${admin}">ADMINISTRADOR</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="text" placeholder="Buscar... " style="padding: 5px; width: 100%"/></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div  id="bottom">
        <nav class="navbar navbar-default my-nav">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul id="list" class="nav navbar-nav ">
                        <li><a href="${root}">Inicio</a></li>
                        <li><a href="${root}/carrera">Carreras</a></li>
                        <li><a href="${root}/materia">Materias</a></li>
                        <li><a href="${root}/profesor">Profesores</a></li>
                            <c:choose>
                                <c:when test="${isAdmin == 1}">
                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">ADMIN <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a class="list-item" href="${admin}">HOME</a></li>
                                        <li><a class="list-item" href="${admin}/alta-carrera">ALTA CARRERA</a></li>
                                        <li><a class="list-item" href="${admin}/alta-materia">ALTA MATERIA</a></li>
                                        <!--<li><a class="list-item" href="${admin}/alta-profesor">ALTA PROFESOR</a></li>--> 
                                    </ul>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="#">...</a></li>
                                </c:otherwise>
                            </c:choose>

                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>