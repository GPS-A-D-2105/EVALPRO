/*
 * Copyright (C) 2015 vrebo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.itver.evalpro.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.itver.evalpro.mail.Correo;
import org.itver.evalpro.mail.Usuario;
import org.itver.evalpro.persistencia.dao.dto.Administrador;
import org.itver.evalpro.persistencia.dao.dto.Carrera;
import org.itver.evalpro.persistencia.dao.dto.Comentario;
import org.itver.evalpro.persistencia.dao.dto.Maestro;
import org.itver.evalpro.persistencia.dao.dto.Materia;
import org.itver.evalpro.persistencia.dao.dto.Reseña;
import org.itver.evalpro.persistencia.servicio.ServicioPersistencia;

/**
 *
 * @author vrebo
 */
public class Servlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        checkIfAdmin(request, response);
        String contextPath = request.getServletPath();
        System.out.println("Atendiendo petición http mediante método GET");
        System.out.println(request.getRequestURI());
        RequestDispatcher dispatcher = null;
        ServicioPersistencia sp;
        String redirect = "asd";
        switch (contextPath) {
            case "/welcome":
                redirect = "/jsp/index.jsp";
                break;
            case "/carrera":
                System.out.println("Despachando petición de /carrera");
                List<Carrera> carreras = new ServicioPersistencia().buscarCarreras();
                System.out.println("Carreras consultadas");
                request.setAttribute("listaCarreras", carreras);
                redirect = "/jsp/carreras.jsp";
                break;
            case "/materia":
                System.out.println("Despachando petición de /materia");
                List<Materia> listaMaterias;
                String id = request.getParameter("idCarrera");
                sp = new ServicioPersistencia();
                if (id != null) {
                    int idCarrera = Integer.parseInt(id);
                    listaMaterias = sp.buscarMateriasPorCarrera(idCarrera);
                } else {
                    listaMaterias = sp.buscarMaterias();
                }
                sp.cerrarServicio();
                request.setAttribute("listaMaterias", listaMaterias);
                System.out.println("Redireccionando a materias.jsp");
                redirect = "/jsp/materias.jsp";
                break;
            case "/acerca":
                redirect = "/jsp/acerca.jsp";
                break;
            case "/profesor":
                String sIdProf = request.getParameter("idMateria");
                List<Maestro> listaMaestros;
                sp = new ServicioPersistencia();
                if (sIdProf == null) {
                    System.out.println("Mostrando lista de maestros.");
                    listaMaestros = sp.buscarMaestros();
                } else {
                    int idMateria = Integer.parseInt(sIdProf);
                    listaMaestros = sp.buscarMaestrosPorMateria(idMateria);
                    String sNombreMateria = request.getParameter("nombreMateria");
                    request.setAttribute("nombreMateria", sNombreMateria);
                    request.setAttribute("tipoConsulta", 1);
                }
                sp.cerrarServicio();
                request.setAttribute("listaMaestros", listaMaestros);
                redirect = "/jsp/profesores.jsp";
                break;
            case "/profesor-info":
                String nombreProfesor = request.getParameter("nombre");
                String sIdMaestro = request.getParameter("id");
                int idMaestro = Integer.parseInt(sIdMaestro);
                sp = new ServicioPersistencia();
                List<Materia> materiasImpartidas = sp.buscarMateriasPorMaestro(idMaestro);

                List<Comentario> comentarios = sp.buscarComentariosNoCensuradorPorProfesor(idMaestro);
                sp.cerrarServicio();
                int[] califs = {0, 0, 0};
                if (!comentarios.isEmpty()) {
                    for (Comentario comentario : comentarios) {
                        califs[0] += comentario.getCalifAsist();
                        califs[1] += comentario.getCalifDomi();
                        califs[2] += comentario.getCalifCalid();
                    }
                    califs[0] /= comentarios.size();
                    califs[1] /= comentarios.size();
                    califs[2] /= comentarios.size();
                }
                request.setAttribute("idProfesor", sIdMaestro);
                request.setAttribute("nombreProfesor", nombreProfesor);
                request.setAttribute("materiasImpartidas", materiasImpartidas);
                request.setAttribute("calificaciones", califs);
                request.setAttribute("comentarios", comentarios);
                redirect = "/jsp/profesor-info.jsp";
                break;
        }
        dispatcher = request.getRequestDispatcher(redirect);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        checkIfAdmin(request, response);
        System.out.println("Atendiendo petición http mediante método POST");
        String contextPath = request.getServletPath();
        System.out.println("contextPath = " + contextPath);
        RequestDispatcher dispatcher;
        ServicioPersistencia sp;
        String redirect = "";
        request.setCharacterEncoding("UTF-8");
        switch (contextPath) {
            case "/publicar-comentario":
                String autor,
                 comentario,
                 nombreProfesor,
                 idProfesor;
                int califAsistencia,
                 califDominio,
                 califCalidad;
                autor = request.getParameter("comment-autor");
                comentario = request.getParameter("comment-content");
                califAsistencia = Integer.parseInt(request.getParameter("calif-asistencia"));
                califCalidad = Integer.parseInt(request.getParameter("calif-calidad"));
                califDominio = Integer.parseInt(request.getParameter("calif-dominio"));
                nombreProfesor = request.getParameter("nombre-profesor");
                idProfesor = request.getParameter("id-profesor");
                System.out.println("autor = " + autor);
                System.out.println("comentario = " + comentario);
                System.out.println("califAsistencia = " + califAsistencia);
                System.out.println("califDominio = " + califDominio);
                System.out.println("califCalidad = " + califCalidad);
                redirect = String.format("/evalpro/profesor-info?nombre=%s&id=%s", nombreProfesor, idProfesor);
                System.out.println("redirect = " + redirect);
                sp = new ServicioPersistencia();
                Reseña reseña
                        = sp.buscarReseñasPorIdMaestro(Integer.parseInt(idProfesor)).get(0);
                Comentario c = new Comentario();
                c.setUsuario(autor);
                c.setContenido(comentario);
                c.setEstado(Comentario.Estado.ESPERA.toString().toLowerCase());
                c.setIdReseña(reseña);
                c.setCalifDomi(califDominio);
                c.setCalifAsist(califAsistencia);
                c.setCalifCalid(califCalidad);
                c.setRegistro(new Date());
                sp.persisitirComentario(c);

                List<Administrador> admins = sp.buscarAdministradores();
                String[] destinatarios = new String[admins.size()];
                for (int i = 0; i < destinatarios.length; i++) {
                    destinatarios[i] = admins.get(i).getCorreo();
                }

                Usuario admi = new Usuario("evalpro.itver@gmail.com", "evaluatec");
                Correo correo = new Correo(admi);
                String notificacion
                        = String.format("Saludos Admin.\nHay un nuevo comentario en espera de revisión: \n\n \"%s\"",
                                c.toString());
                correo.enviarMensaje(destinatarios, 
                        "EvalPro - Nuevo comentario publicado", 
                        notificacion);

                sp.cerrarServicio();
                response.sendRedirect(redirect);
                break;
        }
//        dispatcher = request.getRequestDispatcher(redirect);
//        dispatcher.forward(request, response);
    }

    protected void checkIfAdmin(HttpServletRequest request, HttpServletResponse response) {
        if (request.isUserInRole("administrador")) {
            request.setAttribute("isAdmin", 1);
        }

    }

    //<editor-fold>
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
