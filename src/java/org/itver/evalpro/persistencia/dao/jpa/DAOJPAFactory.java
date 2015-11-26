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
package org.itver.evalpro.persistencia.dao.jpa;

import org.itver.evalpro.persistencia.dao.AdministradorDAO;
import org.itver.evalpro.persistencia.dao.CarreraDAO;
import org.itver.evalpro.persistencia.dao.ComentarioDAO;
import org.itver.evalpro.persistencia.dao.DAOFactory;
import org.itver.evalpro.persistencia.dao.MaestroDAO;
import org.itver.evalpro.persistencia.dao.MateriaDAO;

/**
 * Clase encargada de crear instancias de los DAOs definidos en la API. No hay
 * otro método de tener acceso a las implementaciones de los DAOs que a través
 * de esta clase.
 *
 * @author vrebo
 */
public final class DAOJPAFactory implements DAOFactory {

    //No se permite crear instancias de esta clase
    private DAOJPAFactory() {
    }

    /**
     * Método estático para la creación de instancias de esta clase.
     * @return An instance of DAOJPAFactory.
     */
    public static DAOFactory getInstance() {
        return new DAOJPAFactory();
    }

    @Override
    public CarreraDAO getCarreraDAO() {
        return new CarreraJPAImpl();
    }

    @Override
    public ComentarioDAO getComentarioDAO() {
        return new ComentarioJPAImpl();
    }

    @Override
    public MaestroDAO getMaestroDAO() {
        return new MaestroJPAImpl();
    }

    @Override
    public MateriaDAO getMateriaDAO() {
        return new MateriaJPAImpl();
    }

    @Override
    public AdministradorDAO getAdministradorDAO() {
        return new AdministradorJPAImpl();
    }

}
