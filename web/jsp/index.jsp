<%-- 
    Document   : Index
    Created on : 28-oct-2015, 11:04:09
    Author     : vrebo
--%>
<%@include file="variables.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>EvalPro</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link href="${css}/main.css" rel="stylesheet" />
        <link href="${css}/nav-bar.css" rel="stylesheet"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>       
    </head>
    <body>
        <%@include file="nav-bar.jsp" %>
        <main>
            <div id="contenido">
                <h1>Bienvenidos</h1>
                <div class="main">
                    <div class="slides">
                        <img src="${root}/imagenes/slider/paisaje1.png"/>
                        <img src="${root}/imagenes/slider/paisaje2.png"/>
                        <img src="${root}/imagenes/slider/paisaje3.png"/>
                        <img src="${root}/imagenes/slider/paisaje4.png"/>
                    </div>
                </div>
                <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
                <script src="../js/jquery.slides.js"></script>
                <script>

                    $(function () {
                        $(".slides").slidesjs({
                            play: {
                                active: true,
                                // [boolean] Generate the play and stop buttons.
                                // You cannot use your own buttons. Sorry.
                                effect: "slide",
                                // [string] Can be either "slide" or "fade".
                                interval: 5000,
                                // [number] Time spent on each slide in milliseconds.
                                auto: true,
                                // [boolean] Start playing the slideshow on load.
                                swap: true,
                                // [boolean] show/hide stop and play buttons
                                pauseOnHover: false,
                                // [boolean] pause a playing slideshow on hover
                                restartDelay: 2500
                                        // [number] restart delay on inactive slideshow
                            }
                        });
                    });

                </script>
                <h1><font color="8CC63F" size=10>Ranking de Profesores mejor calificados</font></h1>
                <script src="${root}/js/Chart.js"></script>
                <div id="canvas-holder">
                    <canvas id="chart-area3" width="200" height="100"></canvas>
                </div>
                <script>

                    var barChartData = {
                        labels: ["Profesor 7", "Profesor 6", "Profesor 5", "Profesor 4", "Profesor 3", "Profesor 2", "Profesor 1"],
                        datasets: [
                            {
                                fillColor: "#6ACA25",
                                strokeColor: "#ffffff",
                                highlightFill: "#1864f2",
                                highlightStroke: "#ffffff",
                                data: [7, 7.2, 7.5, 7.7, 8.5, 9.5, 10]
                            },
                        ]

                    }


                    var ctx3 = document.getElementById("chart-area3").getContext("2d");

                    window.myPie = new Chart(ctx3).Bar(barChartData, {responsive: true});

                </script>
            </div>
        </main>
        <%@include file="footer.jsp" %>
    </body>
</html>
