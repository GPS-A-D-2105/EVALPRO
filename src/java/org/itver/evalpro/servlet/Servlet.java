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
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.itver.evalpro.persistencia.dao.dto.Carrera;
import org.itver.evalpro.persistencia.dao.dto.Comentario;
import org.itver.evalpro.persistencia.dao.dto.Maestro;
import org.itver.evalpro.persistencia.dao.dto.Materia;
import org.itver.evalpro.persistencia.dao.servicios.ServicioPersistencia;
import org.jboss.logging.Logger;

/**
 *
 * @author vrebo
 */
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(request.getServletPath());
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login exitoso</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void badAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(request.getServletPath());
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Usuario inválido.</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        String contextPath = request.getServletPath();
        System.out.println("Atendiendo petición http mediante método GET");
        System.out.println(request.getRequestURI());
        RequestDispatcher dispatcher = null;
        ServicioPersistencia sp;
        switch (contextPath) {
            case "/carrera":
                System.out.println("Despachando petición de /carrera");
                List<Carrera> carreras = new ServicioPersistencia().buscarCarreras();
                System.out.println("Carreras consultadas");
                request.setAttribute("listaCarreras", carreras);
                dispatcher = request.getRequestDispatcher("/jsp/carreras.jsp");
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
                dispatcher = request.getRequestDispatcher("/jsp/materias.jsp");
                break;
            case "/acerca":
                dispatcher = request.getRequestDispatcher("/jsp/acerca.jsp");
                break;
            case "/admin":
                dispatcher = request.getRequestDispatcher("/jsp/admin/login-admin.jsp");
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
                dispatcher = request.getRequestDispatcher("/jsp/profesores.jsp");
                break;

            case "/profesor-info":

                String nombreProfesor = request.getParameter("nombre");
                String sIdMaestro = request.getParameter("id");
                int idMaestro = Integer.parseInt(sIdMaestro);
                sp = new ServicioPersistencia();
                List<Materia> materiasImpartidas = sp.buscarMateriasPorMaestro(idMaestro);
                List<Comentario> comentarios = sp.buscarComentariosPorMaestro(idMaestro);
                sp.cerrarServicio();
                double[] califs = {0, 0, 0};

                for (Comentario comentario : comentarios) {
                    califs[0] += comentario.getCalifAsist();
                    califs[1] += comentario.getCalifDomi();
                    califs[2] += comentario.getCalifCalid();
                }
                califs[0] /= comentarios.size();
                califs[1] /= comentarios.size();
                califs[2] /= comentarios.size();
                
                request.setAttribute("nombreProfesor", nombreProfesor);
                request.setAttribute("materiasImpartidas", materiasImpartidas);
                request.setAttribute("calificaciones", califs);
                request.setAttribute("comentarios", comentarios);
                dispatcher = request.getRequestDispatcher("/jsp/profesor-info.jsp");
                break;
            default:
                Logger.getLogger(Servlet.class).debug("No se encuentra el recurso solicitado");
                processRequest(request, response);
                return;
        }
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
        System.out.println("Atendiendo petición http mediante método POST");
        String contextPath = request.getServletPath();
        System.out.println("contextPath = " + contextPath);
        RequestDispatcher dispatcher = null;
        switch (contextPath) {
            case "/comentario":
                String usuario = request.getParameter("usuario");
                String contenido = request.getParameter("contenido-comentario");
                System.out.println("usuario = " + usuario);
                System.out.println("contenido = " + contenido);
                break;
        }
        dispatcher.forward(request, response);
    }

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
