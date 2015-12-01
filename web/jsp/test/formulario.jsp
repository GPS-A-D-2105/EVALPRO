<%-- 
    Document   : formulario
    Created on : 12-nov-2015, 22:01:28
    Author     : vrebo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../variables.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--<link href="../../css/principal.css" rel="stylesheet"/>-->

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        <!--<link href="prueba.css" rel="stylesheet"/>-->
        <link href="header.css" rel="stylesheet"/>
        <link href="formulario.css" rel="stylesheet"/>
        <title>JSP Page</title>
    </head>
    <body style="margin: auto;">
        <!--<h1>Hello World!</h1>-->

        <div id="login">
            <img src="${root}/imagenes/EvalPro.png" alt="Evalpro"/>            
            <form class="form-horizontal" role="form" action="j_security_check" method="POST">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="j_username">USUARIO:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="j_username" placeholder="Ingresa tu username" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="j_password">CONTRASEÑA:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="j_password" placeholder="Ingresa tu contraseña" required>
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

        <!--        
        <div style="background-color: gray;">
            <section id="header">
                    <div id="logo-eslogan">
                        <img id="logo" src="../../imagenes/EvalPro.png" />
                        <h4>Aquí va un eslogan.</h4>
                    </div>
                    <nav class="nav-bar-2">
                        <ul>
                            <li><a href="${root}">INICIO</a></li>
                            <li><a href="${root}/carrera">ACERCA</a></li>
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
    
        <%--<%@include file="../header.jsp" %>--%>
        <main>  
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="email">Email:</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="email" placeholder="Enter email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pwd">Password:</label>
                                <div class="col-sm-10">          
                                    <input type="password" class="form-control" id="pwd" placeholder="Enter password">
                                </div>
                            </div>
                            <div class="form-group">        
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div class="checkbox">
                                        <label><input type="checkbox"> Remember me</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">        
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default">Submit</button>
                                </div>
                            </div>
                        </form>
            <aside>
                <div class="cabecera-caja-com">
                    <header>Comentarios</header>
                </div>
                <section class="caja-comentarios">
                    <article class="cuadro-comentario">
                        <table>
                            <tr>
                                <td class="td-usuario" >USUARIO</td>
                                <td class="td-fecha">FECHA</td>
                            </tr>
                            <tr>
                                <td class="td-contenido">
                                    <div class="div-contenido">
                                        CONTENIDOOOOOOOOOOOOOOOOOOOO y pues comento que no se que comentar respecto al maestro. Lorem ipsum dolor.
                                        CONTENIDOOOOOOOOOOOOOOOOOOOO y pues comento que no se que comentar respecto al maestro. Lorem ipsum dolor.
                                        CONTENIDOOOOOOOOOOOOOOOOOOOO y pues comento que no se que comentar respecto al maestro. Lorem ipsum dolor.
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </article>
                    <article class="cuadro-comentario">
                        <table>
                            <tr>
                                <td class="td-usuario" >USUARIO</td>
                                <td class="td-fecha">FECHA</td>
                            </tr>
                            <tr>
                                <td class="td-contenido">
                                    <div class="div-contenido">
                                        CONTENIDOOOOOOOOOOOOOOOOOOOO y pues comento que no se que comentar respecto al maestro. Lorem ipsum dolor.
    
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </article>
                    <article class="cuadro-comentario">
                        <table>
                            <tr>
                                <td class="td-usuario" >USUARIO</td>
                                <td class="td-fecha">FECHA</td>
                            </tr>
                            <tr>
                                <td class="td-contenido">
                                    <div class="div-contenido">
                                        CONTENIDOOOOOOOOOOOOOOOOOOOO y pues comento que no se que comentar respecto al maestro. Lorem ipsum dolor.
                                        CONTENIDOOOOOOOOOOOOOOOOOOOO y pues comento que no se que comentar respecto al maestro. Lorem ipsum dolor.
                                        CONTENIDOOOOOOOOOOOOOOOOOOOO y pues comento que no se que comentar respecto al maestro. Lorem ipsum dolor.
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </article>
                    <article class="cuadro-comentario">
                        <table>
                            <tr>
                                <td class="td-usuario" >USUARIO</td>
                                <td class="td-fecha">FECHA</td>
                            </tr>
                            <tr>
                                <td class="td-contenido">
                                    <div class="div-contenido">
                                        CONTENIDOOOOOOOOOOOOOOOOOOOO y pues comento que no se que comentar respecto al maestro. Lorem ipsum dolor.
    
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </article>
                </section>
                <section class="form-comentario">
                    <form action="#" method="POST">
                        <input class="input-nombre" name="usuario" type="text" placeholder="Escribe tu nombre..."/>
                        <textarea name="contenido-comentario" placeholder="Escribe aquí tu comentario...">
                        </textarea>
                        <input class="input-enviar" type="submit" value="ENVIAR"/>
                    </form>
                </section>
            </aside>
        </main>
    </div>
        -->
    </body>
</html>
