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
package org.itver.evalpro.persistencia.dao;

/**
 * Interface que define el comportamiento de una Factoría de creación de DAOs.
 *
 * @author vrebo
 */
public interface DAOFactory {

    /**
     * Devuelve una instancia de CarreraDAO.
     *
     * @return instancia de CarreraDAO
     */
    CarreraDAO getCarreraDAO();

    /**
     * Devuelve una instancia de ComentarioDAO.
     *
     * @return instancia de ComentarioDAO.
     */
    ComentarioDAO getComentarioDAO();

    /**
     * Devuelve una instancia de MateriaDAO.
     *
     * @return instancia de MateriaDAO
     */
    MateriaDAO getMateriaDAO();

    /**
     * Devuelve una instancia de MaestroDAO.
     *
     * @return instancia de MaestroDAO
     */
    MaestroDAO getMaestroDAO();

    /**
     * Devuelve una instancia de AdministradorDAO
     * @return instancia de AdministradorDAO
     */
    AdministradorDAO getAdministradorDAO();
}
