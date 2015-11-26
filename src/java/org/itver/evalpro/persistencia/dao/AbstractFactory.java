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

import org.itver.evalpro.persistencia.dao.jpa.DAOJPAFactory;

/**
 * Clase encargada de crear instancias de las Factorias definidas en la API.
 *
 * @author vrebo
 */
public class AbstractFactory {

    //Nel, no se puede instancia esta clase.
    private AbstractFactory() {
    }

    /**
     * Crea una instancia de DAOFactory configurado para ser usado. Actualmente
     * la configuración está dentro del mismo método.
     *
     * @return Una instancia de DAOFactory.
     */
    public static DAOFactory getDAOFactory() {
        //Variable de configuración de la creación de los DAOFactory's.
        String factoryVendor = "";
        switch (factoryVendor) {
            //Hasta el momento solo se tiene una clase que implementa la 
            //interface DAOFactory.
            default:
                return DAOJPAFactory.getInstance();
        }
    }

}
