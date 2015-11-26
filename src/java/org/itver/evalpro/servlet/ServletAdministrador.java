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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.itver.evalpro.persistencia.dao.dto.Administrador;
import org.itver.evalpro.persistencia.dao.servicios.ServicioPersistencia;

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
        System.out.println(servletPath);
        RequestDispatcher dispatcher = null;
        String urlForward = "/";
        switch (servletPath) {
            case "/admin":
                urlForward = "/jsp/admin/workspace.jsp";
                break;
            case "/admin/alta-admin":
                urlForward = "/jsp/admin/alta-admin.jsp";
                break;
            case "/admin/gestion-admin":
                ServicioPersistencia sp = new ServicioPersistencia();
                List<Administrador> admins = sp.buscarAdministradores();
                request.setAttribute("listaAdmins", admins);
                urlForward = "/jsp/admin/gestion-admin.jsp";
                sp.cerrarServicio();
                break;
            case "/admin/baja-admin":
                int idAdmin = Integer.parseInt(request.getParameter("id"));
                Administrador admin = new Administrador(idAdmin);
                ServicioPersistencia _sp = new ServicioPersistencia();
                _sp.eliminarAdministrador(admin);
                _sp.cerrarServicio();
                List<Administrador> adminss = _sp.buscarAdministradores();
                request.setAttribute("listaAdmins", adminss);
                urlForward = "/jsp/admin/gestion-admin.jsp";
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

        String servletPath = request.getServletPath();
        RequestDispatcher dispatcher = null;
        String urlForward = "/";
        switch (servletPath) {

            case "/login-admin":
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                System.out.println("user = " + user);
                System.out.println("pass = " + pass);
                ServicioPersistencia _sp = new ServicioPersistencia();
                Administrador admin = _sp.buscarAdministradorPorId(user);
                _sp.cerrarServicio();
                if (admin != null && admin.getPassword().equals(pass)) {
                    urlForward = "/jsp/admin/workspace.jsp";
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
                Administrador admin_ = new Administrador();
                admin_.setNumeroControl(noControl);
                admin_.setNombre(nombre);
                admin_.setApellidoPaterno(apPaterno);
                admin_.setApellidoMaterno(apMaterno);
                admin_.setPassword(password);
                admin_.setNumeroControl(noControl);
                admin_.setCorreo(email);;
                ServicioPersistencia sp = new ServicioPersistencia();
                sp.persisitirAdministrador(admin_);
                sp.cerrarServicio();
                urlForward = "/jsp/admin/alta-admin.jsp";
                break;
        }
        dispatcher = request.getRequestDispatcher(urlForward);
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
    }

}
