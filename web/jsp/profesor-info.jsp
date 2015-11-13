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
        <!--    <link rel="stylesheet" href="estilos.css"/>-->
        <!--<link rel="stylesheet" href="fonts.css"/>-->
    </head>
    <body>
        <%@include file="header.jsp" %>

        <div id="contenido">

            <script src="Chart.js"></script>
            <div id="canvas-holder">
                <h4><font color="#2BB673">
                        <form name="form1" method="post" action=""><h1 align="center"><font color="#2BB673">Estadisticas</h1>
                        </form>
                </h4>
                <h4>&nbsp;</h4>
                <h4>&nbsp;</h4>
                <h4><font size="6">${nombreProfesor}</font></h4>
                </h4>
                <form name="form4" method="post" action="">
                    <table width="341" height="427" border="0" align="right" id="panel">
                        <tr>
                            <td height="42" align="center" bgcolor="#2BB673"><div align="center"><font color="#000000">Comentarios</font></div></td>
                        </tr>
                        <tr>
                            <td height="84" bgcolor="#CCCCCC"><table width="334" height="88" border="0">
                                    <tr>
                                        <td width="126" height="18" bgcolor="#FFFFFF"><font color="0F75BC">Usuario 1</font> </td>
                                        <td width="167" bgcolor="#FFFFFF"><div align="right"><font color="8CC63F">27/10/2015</font></div></td>
                                    </tr>
                                    <tr>
                                        <td height="18" colspan="2" bgcolor="#FFFFFF"><font color="#000000">No puedo hablar mal de ella porque me da servicio social :v</font></td>
                                    </tr>
                                </table>
                                <table width="323" border="3">
                                    <tr>
                                    </tr>
                                </table></td>
                        </tr>
                        <tr>
                            <td bgcolor="#CCCCCC"><table width="334" height="88" border="0">
                                    <tr>
                                        <td width="126" height="18" bgcolor="#FFFFFF"><font color="0F75BC">Anonimo</font> </td>
                                        <td width="167" bgcolor="#FFFFFF"><div align="right"><font color="8CC63F">17/10/2012</font></div></td>
                                    </tr>
                                    <tr>
                                        <td height="18" colspan="2" bgcolor="#FFFFFF"><font color="#000000">En mi opinion personal mia de mi, opino que este profesor es bueno :v</font></td>
                                    </tr>
                                </table></td>
                        </tr>
                        <tr>
                            <td bgcolor="#CCCCCC"><table width="334" height="88" border="0">
                                    <tr>
                                        <td width="126" height="18" bgcolor="#FFFFFF"><font color="0F75BC">Usuario 2</font></td>
                                        <td width="167" bgcolor="#FFFFFF"><div align="right"><font color="8CC63F">10/10/2013</font></div></td>
                                    </tr>
                                    <tr>
                                        <td height="18" colspan="2" bgcolor="#FFFFFF"><font color="#000000">En mi opinion personal mia de mi, opino que este profesor es bueno :v</font></td>
                                    </tr>
                                </table></td>
                        </tr>
                        <tr>
                            <td bgcolor="#CCCCCC"><table width="334" height="88" border="0">
                                    <tr>
                                        <td width="126" height="18" bgcolor="#FFFFFF"><font color="0F75BC">Usuario 3</font></td>
                                        <td width="167" bgcolor="#FFFFFF"><div align="right"><font color="8CC63F">8/07/2015</font></div></td>
                                    </tr>
                                    <tr>
                                        <td height="18" colspan="2" bgcolor="#FFFFFF"><font color="#000000">En mi opinion personal mia de mi, opino que este profesor es bueno :v</font></td>
                                    </tr>
                                </table></td>
                        </tr>
                    </table>
                </form>
                <canvas id="chart-area2" width="200" height="200"></canvas>

            </div>

            <p><script>
                var pieData = [{value: 10, color: "#8CC63F", highlight: "#0b82e7", label: "Asistencia"},
                    {
                        value: 30,
                        color: "#13A89E",
                        highlight: "#e3e860",
                        label: "Dominio del tema"
                    },
                    {
                        value: 20,
                        color: "#0F75BC",
                        highlight: "#b74865",
                        label: "Calidad de enseñanza"
                    },
                ];


                var ctx2 = document.getElementById("chart-area2").getContext("2d");
                window.myPie = new Chart(ctx2).Doughnut(pieData);
                </script> 

                <table width="255" border="1">
                    <tr>
                        <td width="22"  BGCOLOR="#8CC63F" >&nbsp;</td>
                        <td width="175"><font color="Black">Asistencia</td>
                    </tr>
                    <tr>
                        <td width="22"  BGCOLOR="#13A89E">&nbsp;</td>
                        <td><font color="Black">Dominio del tema</td>
                    </tr>
                    <tr>
                        <td width="22"  BGCOLOR="#0F75BC">&nbsp;</td>
                        <td><font color="Black">Calidad de enseñanza</td>
                    </tr>
                </table> 
                <p>&nbsp;</p>
                <p><font color="2BB673" SIZE=5 >Materias Impartidas</font></p>
                <c:forEach var="materias" items="${materiasImpartidas}">
                    <p>
                        <font color="0F75BC" SIZE=4>${materias.nombreMateria}</font>
                    </p>
                </c:forEach>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <table width="287" height="199" border="0" align="right">
                    <tr>
                        <td height="0" bgcolor="#999999"><form name="form2" method="post" action="">
                                <label for="nombre"></label>
                                <div align="center"><span class="row">
                                        <input id="name" class="input" name="name" type="text" value="" size="45" placeholder="Nombre" />
                                    </span></div>
                            </form></td>
                    </tr>
                    <tr>
                        <td height="0" bgcolor="#999999"><form name="form3" method="post" action="">
                                <label for="comentario1"></label>
                                <label for="comentario"></label>
                                <div align="center"><span class="row">
                                        <textarea id="message" class="input" name="message" rows="7" cols="45" placeholder="Comentario"></textarea>
                                        <input type="submit" name="Enviar" id="Enviar" value="Enviar">
                                    </span>
                                </div>
                            </form></td>
                    </tr>
                    <tr></tr>
                </table>
            </p>
            <p>&nbsp;</p>

        </div>
        <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
