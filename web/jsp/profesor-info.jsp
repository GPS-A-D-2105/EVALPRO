<%-- 
    Document   : profesor-info
    Created on : 13-nov-2015, 16:11:54
    Author     : vrebo
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@include file="variables.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Evalpro - Info. Profesor</title>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link href="${css}/main.css" rel="stylesheet" />
        <link href="${css}/nav-bar.css" rel="stylesheet"/>
        <!--<link href="${css}/profesor-info.css" rel="stylesheet"/>-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>  
        <script src="${js}/grafica.js"></script>
        <style>

            p.numero {
                display: inline-block;
                color: #808080;
            }

            div#grafico {
                margin-left:30px;
                position: relative;
                display:inline-block;
            }

            div#grafico article {
                position: absolute;
            }

            article#ce {
                margin-top:15px;
                margin-left: 85px;
            }

            article#ct {
                margin-left: 30px;
                margin-top: 145px;
            }

            article#asist {
                margin-left: 140px;
                margin-top: 145px;
            }

            #ptotal {
                font-size: 55px;
                margin-top: 70px;
                margin-left: 60px;
            }

            #campos section, #campos h5 {
                display: inline-block;
            }
            #campos{
                margin-top:40px;
                float:right;
                display:inline-block;


            }


            #campos section {
                width: 18px;
                height: 18px;
            }

            #campos section#azul {
                background-color: #13A89E;
            }

            #campos section#verdeazul {
                background-color: #0F75BC;
            }

            #campos section#verde {
                background-color: #8CC63F;
            }

            .campo{
                margin-top:20px;
            }

            div#orden h1{
                margin-top:40px;
                margin-left:30px;
                font-size:22px;
                color:#13A89E;
            }

            #grafCampo {
                margin-top:45px;
                margin-bottom:55px;
            }

            #orden h3{
                font-size:32px;
                color:#2BB673;
                text-align:center;
                margin-bottom:20px;
            }
            /*            dt{
                            text-align:center;
                            margin-bottom:10px;
                            color:#0F75BC;
                            font-size:20px;
                        }*/
        </style>
        <style>
            *{
                font-family: "Arial";
            }
            body{
                background-color: #EEEEEE;
            }

            #comment-panel-container{
                width: available;   
                margin: auto;
                float: inside;
            }

            #comment-panel{
                min-width: 300px;
                max-width: available;
                margin: auto;                
            }

            #comment-panel header{
                background-color: #2BB673;
                color:white;
                text-transform: uppercase;
                text-align: center;
                /*line-height: 50px;*/
                padding: 10px;
                height: 50px;
            }
            #comment-panel h4{
                font-weight: bold;
            }
            #comment-box{
                background-color: #D9D9D9;
                overflow-y: scroll;
                min-height: 400px;
                height: fit-content;
                max-height: 500px;
            }

            .comment{
                background-color: white;
                padding: 10px;
                margin: 20px;
                height: fit-content;
            }

            .comment table{
                /*padding: 15px;*/
                width: 100%;
                height: fit-content;
            }

            .comment th{
                font-size: 13px;
            }

            .comment tr > th {
                color: #3A8DDC;
                text-align: left;
            }

            .comment tr > th + th{
                color: #8CC63F;
                text-align: right;
            }
            
            
            
            .comment tr + tr > td{
                padding: 20px 0px 20px 0px;
                font-size: 15px;
                width: 100%;
                /*display: inline;*/
                /*min-width: 10px;*/
                /*background-color: red;*/
            }

            #professor-data{
                width: available;
                /*float: left;*/
                text-align: center;
                margin: auto;
            }
        </style>
        <style>
            h2{
                color: #388CC7;;
            }

            .center{
                margin: auto;
            }

            ul#aspects{
                margin-top: 60px;
                text-align: left;
                font-size: larger;
                /*font-weight: bold;*/
            }

            ul#aspects li{
                margin: 15px;
            }

            .square{
                min-height: 25px;
                min-width: 25px;
                max-height: 25px;
                max-width: 25px;
            }

            .blue{
                background-color: #388CC7;
            }

            .aqua{
                background-color: #40B9B0;
            }

            .lima{
                background-color: #A2D163;
            }

            ul#materias-impartidas{
                margin-left: 30px;
                text-align: left;
                font-weight: bold;
                list-style-image: url("${images}/lima-triangle.png");
            }

            ul#materias-impartidas > li{
                color: #A2D163;
                font-size: xx-large;
            }

            ul#materias-impartidas li > ul{
                color: #388CC7;
                font-size: large;
                list-style-image: url("${images}/lima-circle.png");
            }
        </style>
        <style>
            #post-comment form{
                min-width: 300px;
                max-width: available;
                margin: auto;                
                margin-top: 15px;
                padding: 15px;
                background-color: #D9D9D9;
            }
            #post-comment input[type=text]{
                margin: auto;
                margin-bottom: 5px;
                width: 100%;
                padding: 3px;
            }
            #post-comment textarea{
                width: 100%;
                resize: none;
            }

            #post-comment p{
                background-color: #2BB673;
                color: white;
                text-align: center;
                font-weight: bolder;
                margin-top: 10px;
                padding: 7px 5px 7px 5px;
            }

            #post-comment input[type=number]{
                width: 40px;
                margin-right: 5px;
                color: black;
            }

            #post-comment input[type=submit]{
                padding: 5px 10px 5px 10px;
                margin: 5px;
                color: white;
                border-radius: 5px;
                border: 0px;
                background-color: #2BB673;
                position: relative;
                margin-left: calc(100% - 70px);
            }

            .rounded-box{
                border-radius: 10px;
                /*background-color: red;*/
                width: available;
                min-width: 100px;
                margin: 5px;
                padding: 10px;
                font-size: 13px;
                font-weight: bold;
                color: white;
            }
        </style>
    </head>
    <body onload="dibujarCanvas();">
        <%@include file="nav-bar.jsp" %>       
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h1>Estadísticas del profesor</h1>     
                </div>
            </div>
            <div class="row center">
                <div id="professor-data" class="col-md-7">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>${nombreProfesor}</h2>    
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-5">
                            <section id="grafCampo">
                                <div id="grafico">
                                    <article id="ce">
                                        <fmt:setLocale value="en_US"/>
                                        <p id="a" class="numero"><fmt:formatNumber type="NUMBER" value="${calificaciones[1]}" maxFractionDigits="2" pattern="##.##"/></p><p class="numero">%</p>
                                    </article>
                                    <article id="ct">
                                        <fmt:setLocale value="en_US"/>
                                        <p id="b" class="numero"><fmt:formatNumber type="NUMBER" value="${calificaciones[2]}" maxFractionDigits="2"  pattern="##.##"/></p><p class="numero">%</p>
                                    </article>
                                    <article id="asist">
                                        <fmt:setLocale value="en_US"/>
                                        <p id="c" class="numero"><fmt:formatNumber type="NUMBER" value="${calificaciones[0]}" maxFractionDigits="2"  pattern="##.##"/></p><p class="numero">%</p>
                                    </article>
                                    <article id="ptotal"></article>
                                    <canvas id="miCanvas" width="200" height="200"></canvas>
                                </div>
                            </section>

                        </div>
                        <div class="col-md-7">
                            <ul id="aspects">
                                <li style="list-style-image: url('${images}/blue-square.png');">Calidad de enseñanza</li>
                                <li style="list-style-image: url('${images}/aqua-square.png');">Dominio del tema</li>
                                <li style="list-style-image: url('${images}/lima-square.png');">Asistencia</li>
                            </ul>
                        </div>
                    </div>
                    <div class="row center">
                        <div class="col-md-12">
                            <ul id="materias-impartidas">
                                <li>
                                    Materias impartidas
                                    <ul><c:forEach var="materias" items="${materiasImpartidas}">
                                            <li>${materias.nombre}</li>
                                            </c:forEach>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div id="comment-panel-container" class="col-md-5">
                    <section id="comment-panel">
                        <header>
                            <h4>Comentarios</h4>
                        </header>
                        <div id="comment-box">
                            <c:forEach var="comentario" items="${comentarios}">
                                <div class="comment">
                                    <table>
                                        <tr>
                                            <th>${comentario.usuario}</th>
                                            <th><fmt:formatDate pattern="dd/MM/yyyy" value="${comentario.registro}"/></th>
                                        </tr>
                                        <tr>
                                            <td colspan="2">${comentario.contenido}</td>
                                        </tr>
                                    </table>
                                </div>
                            </c:forEach>
                        </div>
                    </section>

                    <section id="post-comment">                        
                        <form action="${root}/publicar-comentario" method="POST">
                            <input name="id-profesor" hidden="true" 
                                   value="${idProfesor}"/>
                            <input name="nombre-profesor" hidden="true" 
                                   value="${nombreProfesor}"/>
                            <input name="comment-autor" type='text' 
                                   placeholder="Tu nombre..." 
                                   required/>
                            <textarea name="comment-content" 
                                      maxlength="140"
                                      placeholder="Escribe aquí tu comentario..."
                                      rows="5"

                                      ></textarea>
                            <p>Por favor selecciona un número del 1 al 10 para cada criterio a evaluar</p>
                            <div class="rounded-box lima">
                                <input name="calif-asistencia" 
                                       type="number" 
                                       min="1" 
                                       max="10"
                                       required/>Asistencia
                            </div>    
                            <div class="rounded-box aqua">
                                <input name="calif-dominio" 
                                       type="number" min="1" 
                                       max="10"
                                       required/>Dominio del tema
                            </div>
                            <div class="rounded-box blue"> 
                                <input name="calif-calidad" 
                                       type="number" 
                                       min="1" 
                                       max="10"
                                       required/>Calidad de enseñanza    
                            </div>
                            <input type="submit"/>
                        </form>
                    </section>
                </div>

            </div>
        </div>         
        <%@include file="footer.jsp" %>
    </body>
</html>