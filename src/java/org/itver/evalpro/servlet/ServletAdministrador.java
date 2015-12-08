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
import org.itver.evalpro.persistencia.dao.dto.Administrador;
import org.itver.evalpro.persistencia.dao.dto.Carrera;
import org.itver.evalpro.persistencia.dao.dto.Comentario;
import org.itver.evalpro.persistencia.dao.dto.Maestro;
import org.itver.evalpro.persistencia.dao.dto.Materia;
import org.itver.evalpro.persistencia.servicio.ServicioPersistencia;

/**
 *
 * @author vrebo
 */
public class ServletAdministrador extends HttpServlet {

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
        String servletPath = request.getServletPath();
        System.out.println("Atendiendo petición para " + servletPath);
        RequestDispatcher dispatcher = null;
        String urlForward = "/";
        request.setAttribute("isAdmin", 1);
        ServicioPersistencia sp = null;
        switch (servletPath) {
            case "/admin/logout":
                request.logout();
                urlForward = "/evalpro/welcome";
                response.sendRedirect(urlForward);
                return;
            case "/admin":
                sp = new ServicioPersistencia();
                List<Maestro> profesores = 
                        sp.buscarMaestrosPorEstadoComentario(Comentario.Estado.ESPERA);
                sp.cerrarServicio();
                request.setAttribute("profesores", profesores);
                urlForward = "/jsp/admin/workspace.jsp";
                break;
            case "/admin/alta-materia":
                urlForward = "/jsp/admin/alta-materia.jsp";
                break;
            case "/admin/alta-carrera":
                urlForward = "/jsp/admin/alta-carrera.jsp";
                break;
            case "/admin/alta-admin":
                urlForward = "/jsp/admin/alta-admin.jsp";
                break;
            case "/admin/gestion-admin":
                sp = new ServicioPersistencia();
                List<Administrador> admins = sp.buscarAdministradores();
                sp.cerrarServicio();
                request.setAttribute("listaAdmins", admins);
                urlForward = "/jsp/admin/gestion-admin.jsp";
                break;
            case "/admin/baja-admin":
                int idAdmin = Integer.parseInt(request.getParameter("id"));
                Administrador admin = new Administrador(idAdmin);
                sp = new ServicioPersistencia();
                sp.eliminarAdministrador(admin);
                List<Administrador> adminss = sp.buscarAdministradores();
                sp.cerrarServicio();
                request.setAttribute("listaAdmins", adminss);
                urlForward = "/jsp/admin/gestion-admin.jsp";
                break;
            case "/admin/gestion-comentarios":
                System.out.println("Mostrando los comentarios más recientes agregados.");
                sp = new ServicioPersistencia();
                List<Comentario> comentarios = sp.buscarComentariosPorEstado(Comentario.Estado.ESPERA);
                sp.cerrarServicio();
                request.setAttribute("comentarios", comentarios);
                urlForward = "/jsp/admin/nuevos-comentarios.jsp";
                break;
            case "/admin/revisar-comentarios":
                String estadoString = request.getParameter("estado").toUpperCase();
                int idComentario = Integer.parseInt(request.getParameter("idComentario"));
                Comentario.Estado estado = Comentario.Estado.valueOf(estadoString);
                sp = new ServicioPersistencia();
                Comentario comentario = sp.buscarComentarioPorId(idComentario);
                comentario.setEstado(estado.toString());
                sp.actualizarComentario(comentario);
                sp.cerrarServicio();
                urlForward = "/admin/gestion-comentarios";
                break;
            case "/admin/revisar-comentarios-prof":
                int idMaestro = Integer.parseInt(request.getParameter("idMaestro"));
                sp = new ServicioPersistencia();
                List<Comentario> comentarios_
                        = sp.buscarComentariosPorEstadoDeProf(idMaestro, Comentario.Estado.ESPERA);
                sp.cerrarServicio();
                request.setAttribute("comentarios", comentarios_);
                urlForward = "/jsp/admin/nuevos-comentarios.jsp";
                break;
        }
        dispatcher = request.getRequestDispatcher(urlForward);
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
        System.out.println("Atendiendo petición en ServletAdministrador con el método POST");
        String servletPath = request.getServletPath();
        request.setAttribute("isAdmin", 1);
        RequestDispatcher dispatcher = null;
        ServicioPersistencia sp;
        Administrador admin;
        String redirect = "/";
        switch (servletPath) {
            case "/admin/publicar-materia":
                System.out.println("Publicando materia");
                request.setCharacterEncoding("UTF-8");
                String nombreMateria = request.getParameter("nombre-materia");
                char creditos = request.getParameter("creditos").toCharArray()[0];
                Materia m = new Materia();
                m.setNombre(nombreMateria);
                m.setCreditos(creditos);
                m.setRegistro(new Date());
                sp = new ServicioPersistencia();
                sp.persistirMateria(m);
                sp.cerrarServicio();
                redirect = "/jsp/admin/workspace.jsp";
                break;
            case "/admin/publicar-carrera":
                System.out.println("Publicando carrera");
                request.setCharacterEncoding("UTF-8");
                String nombreCarrera = request.getParameter("nombre-carrera");
                Carrera c = new Carrera();
                c.setNombre(nombreCarrera);
                sp = new ServicioPersistencia();
                sp.persistirCarrera(c);
                sp.cerrarServicio();
                redirect = "/jsp/admin/workspace.jsp";
                break;
            case "/login-admin":
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                System.out.println("user = " + user);
                System.out.println("pass = " + pass);
                sp = new ServicioPersistencia();
                admin = sp.buscarAdministradorPorId(user);
                sp.cerrarServicio();
                if (admin != null && admin.getPassword().equals(pass)) {
                    redirect = "/jsp/admin/workspace.jsp";
                    break;
                }
                break;
            case "/admin/alta-admin":
                String noControl,
                 nombre,
                 apPaterno,
                 apMaterno,
                 email,
                 password;
                noControl = request.getParameter("no-control");
                nombre = request.getParameter("nombre");
                apPaterno = request.getParameter("ap-paterno");
                apMaterno = request.getParameter("ap-materno");
                email = request.getParameter("email");
                password = request.getParameter("password");
                System.out.println("noControl = " + noControl);
                System.out.println("nombre = " + nombre);
                System.out.println("apPaterno = " + apPaterno);
                System.out.println("apMaterno = " + apMaterno);
                System.out.println("email = " + email);
                System.out.println("password = " + password);
                admin = new Administrador();
                admin.setNumeroControl(noControl);
                admin.setNombre(nombre);
                admin.setApellidoPaterno(apPaterno);
                admin.setApellidoMaterno(apMaterno);
                admin.setUserName(noControl);
                admin.setPassword(password);
                admin.setNumeroControl(noControl);
                admin.setCorreo(email);
                admin.setRegistro(new Date());
                admin.setEstado("activo");
                admin.setRol("administrador");
                sp = new ServicioPersistencia();
                sp.persisitirAdministrador(admin);
                sp.cerrarServicio();
                redirect = "/jsp/admin/alta-admin.jsp";
                break;
        }
        dispatcher = request.getRequestDispatcher(redirect);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String servletPath = request.getServletPath();
//        RequestDispatcher dispatcher = null;
//        ServicioPersistencia sp;
//        String urlFordward = "/";
//        switch (servletPath) {
//            case "/admin/revisar-comentario":
//                String estadoString = request.getParameter("estado").toUpperCase();
//                int idComentario = Integer.parseInt(request.getParameter("idComentario"));
//                Comentario.Estado estado = Comentario.Estado.valueOf(estadoString);
//                sp = new ServicioPersistencia();
//                Comentario comentario = sp.buscarComentarioPorId(idComentario);
//                comentario.setEstado(estado.toString());
//                sp.actualizarComentario(comentario);
//                urlFordward = "/admin/gestion-comentarios";
//                break;
//        }
//        
//        dispatcher = request.getRequestDispatcher(urlFordward);
//        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
