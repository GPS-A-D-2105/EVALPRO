<%-- 
    Document   : profesor-info
    Created on : 13-nov-2015, 16:11:54
    Author     : vrebo
--%>
<%@include file="variables.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title></title>
        <link href="${root}/css/principal.css" rel="stylesheet" />
        <link href="${root}/css/inicio.css" rel="stylesheet" />
        <link href="${root}/css/profesor-info.css" rel="stylesheet"/>
        <link href="${root}/css/header.css" rel="stylesheet"/>
        <script src="${root}/js/Chart.js"></script>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div style="text-align: center; float: top">
            <div id="cmnt-box">
                <!--Cabecera de la caja de comentarios-->
                <header>
                    <h2>COMENTARIOS</h2>
                </header>
                <!--Sección para los comentarios-->
                <section id="section-cmnts">
                    <c:forEach var="comentario" items="${comentarios}">
                        <article class="comment">
                            <table>
                                <tr>
                                    <td class="user">${comentario.usuario}</td>
                                    <td class="date">${comentario.registro}</td>
                                </tr>
                                <tr>
                                    <td class="content" colspan="2">
                                        ${comentario.contenido}
                                    </td>
                                </tr>
                            </table>
                        </article>
                    </c:forEach>
                </section>
                <!--Sección para publicar comentarios-->
                <section id="section-post-cmnt">
                    <form action="" method="POST">
                        <input name="cmnt-autor" type="text" placeholder="Escribe tu nombre..."/>
                        &nbsp;
                        <select name="cmnt-carrer">
                            <option value="default">Materia</option>
                        </select>
                        <select name="cmnt-subject">
                            <option value="default">Carrera</option>
                        </select>
                        <br/>
                        <br/>
                        <textarea name="cmnt-content" placeholder="Escribe tu comentario...">
                        </textarea>
                        <br/>
                        <br/>
                        <input type="submit" value="ENVIAR"/>
                    </form>
                </section>
            </div>

            <main style="float: left;">
                <section id="section-datos-estadisticos">
                    <header>
                        <h1 class="h-estadisticas">ESTADÍSITICAS DEL PROFESOR</h1>
                        <h2>${nombreProfesor}</h2>
                    </header>
                    <div id="canvas-holder" style="float:left;">
                        <canvas id="chart-area">
                        </canvas>
                        <script>
                            var pieData = [
                                {value: ${calificaciones[0]}, color: "#8CC63F", highlight: "#0b82e7", label: "Asistencia"},
                                {
                                    value: ${calificaciones[1]},
                                    color: "#13A89E",
                                    highlight: "#e3e860",
                                    label: "Dominio del tema"
                                },
                                {
                                    value: ${calificaciones[2]},
                                    color: "#0F75BC",
                                    highlight: "#b74865",
                                    label: "Calidad de enseñanza"
                                },
                            ];


                            var ctx2 = document.getElementById("chart-area").getContext("2d");
                            window.myPie = new Chart(ctx2).Doughnut(pieData);
                        </script> 
                    </div>
                    <div id="div-aspectos">
                        <table id="aspectos">
                            <tr><td style="background-color: #0F75BC">  </td><td>Calidad de enseñanza</td></tr>
                            <tr><td style="background-color: #13A89E">  </td><td>Domino del tema</td></tr>
                            <tr><td style="background-color: #8CC63F">&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Asistencia</td></tr>
                        </table>
                        <ul id="aspectos" style="text-align: left;">
                            <li class="calidad"><span>Calidad de enseñanza</span></li>
                            <li class="dominio"><span>Dominio del tema</span></li>
                            <li class="asistencia"><span>Asistencia</span></li>
                        </ul>
                    </div>
                </section>
                <br/>
                <section>
                    <div>
                        <ul id="ul-materias">
                            <li>
                                <header>
                                    <h3 class="titulo-materias">Materias Impartidas</h3>
                                </header>
                            </li>
                            <ul>
                                <c:forEach var="materias" items="${materiasImpartidas}">
                                    <li class="materia">
                                        ${materias.nombre}
                                    </li>
                                </c:forEach>
                            </ul>
                        </ul>
                    </div>
                </section>
            </main>
        </div>
        <%--<%@include file="footer.jsp" %>--%>
    </body>
</html>
