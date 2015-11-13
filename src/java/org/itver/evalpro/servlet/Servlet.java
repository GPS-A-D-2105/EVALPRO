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
import org.itver.evalpro.dto.Administrador;
import org.itver.evalpro.dto.Carrera;
import org.itver.evalpro.dto.Materia;
import org.itver.evalpro.servicio.ServicioPersistencia;
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        if (request.getRequestURI().contains("carrera")) {
            System.out.println("Despachando petición de /carrera");
            List<Carrera> carreras = new ServicioPersistencia().buscarTodasCarreras();
            System.out.println("Carreras consultadas");
            request.setAttribute("listaCarreras", carreras);
            dispatcher = request.getRequestDispatcher("/jsp/carreras.jsp");
        }else if(contextPath.contains("materias")){
            System.out.println("Despachando petición de /materia");
            String id = request.getParameter("idCarrera");
            System.out.println("id = " + id);
            int idCarrera = Integer.parseInt(id);
            List<Materia> materias = new ServicioPersistencia().buscarMateriaPorCarrera(idCarrera);
            request.setAttribute("listaMaterias", materias);
            System.out.println("Redireccionando a materias.jsp");
            dispatcher = request.getRequestDispatcher("/jsp/materias.jsp");
        }else if(contextPath.contains("acerca")){
            dispatcher = request.getRequestDispatcher("/jsp/acerca.jsp");
        }else{
            Logger.getLogger(Servlet.class).debug("No se encuentra el recurso solicitado");
            processRequest(request, response);
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
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        System.out.println("user = " + user);
        System.out.println("pass = " + pass);
        Administrador admin = new ServicioPersistencia().buscarAdminPorId(user);
        if(admin != null && admin.getPassword().equals(pass)){
            processRequest(request, response);
            return;
        }
        badAuthentication(request, response);
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