<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>


        <title></title>
        <link href="../CSS/principal.css" rel="stylesheet" />
        <link href="../CSS/carreras.css" rel="stylesheet" />
  
    </head>
    <body>
        <div id="contenedor">
            <div id="header">
                <section id="compañia">

                    <img src="../imagenes/EvalPro.png" width="180" height="45" />
                    <p id="eslogan">aqui va un slogan</p>

                </section>
                <section id="creadores">
                    <nav id="opciones_pagina">
                        <a href="Inicio2.html">Inicio</a>
                        <a href="Acerca.html">Acerca</a>
                        <a href="Administradores.html">Administradores</a>
                    </nav>
                    <section id="buscador">
                        <input type="search" id="search" placeholder="buscar..." autocomplete="on" border="1" />
                    </section>
                </section>

            </div>

            <div id="menu">
                <nav>
                    <a href="Inicio.html">Inicio</a>
                    <a href="Carrera.php">Carrera</a>
                    <a href="Materias.html">Materias</a>
                    <a href="Profesores.php">Profesores</a>
                    <a href="mas.html">...</a>
                </nav>
            </div>
           
                    <div id="contenidoimg">
            <h1>Selección de Maestros por Carrera</h1>

            <section id="imagenes">
                    <?php
                    session_start();
                    require_once '../connection.php';
//        $anterior=0;
                    $numero = 1;
                    $query = "SELECT * FROM Carrera";
                    $resultset = mysqli_query($databaselink, $query);
                    $rows = mysqli_num_rows($resultset);
                    if ($rows > 0) {
                       // echo '<table>';
                        while ($row = mysqli_fetch_row($resultset)) {
//                $actual=(rand(0, 6)+1);
//                if ($actual==$anterior) {
//                    $actual=(rand(0, 6)+1);
//                }
//                $anterior=$actual;
//                $variable="div".$actual;                                
                            $variable = "article" . $numero;
                            $variable2 = $row[1];

                     //    echo '<tr id="' . $variable . '">';
                            
  //                          echo '</td>';
//                            echo '<td>';
//echo $row[0]; 
                    //       echo '<td>';
                  echo   ' <a href="Materias.html">';
                echo '<article id="' . $variable . '">';
                echo '<h3 >'.$row[1].'</h3>';
                 echo '<img src="../imagenes/Carrearas/computer-2.png" />';
                   echo '</article>';
                echo '</a>';
                            
			//echo $row[1];
                       //     echo '</td>';
//                echo '<td>';
//                echo rand(0, 6)+1;
//                echo '</td>';
                        //    echo '</tr>';
                            $numero++;
                        }
                        //echo '</table>';
                    }
                    ?>
       </section>
        </div>




<!--            <section id="imagenes">
    <img src="../imagenes/Carrearas/Menu1.png" width="184" height="200"/>
    <img src="../imagenes/Carrearas/Menu2.png" width="184" height="200"  />
    <img src="../imagenes/Carrearas/Menu3.png" width="184" height="200" />
    <img src="../imagenes/Carrearas/Menu4.png" width="184" height="200" />
    <img src="../imagenes/Carrearas/Menu5.png" width="184" height="200" />
    <img src="../imagenes/Carrearas/Menu6.png" width="184" height="200" />
    <img src="../imagenes/Carrearas/Menu7.png" width="184" height="200"/>
    <img src="../imagenes/Carrearas/Menu8.png" width="184" height="200" />
    <img src="../imagenes/Carrearas/Menu9.png" width="184" height="200" />
</section>-->
        <!--        </div>-->

        <footer>
            <p>© Copyright Gestion de proyectos 2015 -</p>
        </footer>
        </div>
    </body>
</html>
