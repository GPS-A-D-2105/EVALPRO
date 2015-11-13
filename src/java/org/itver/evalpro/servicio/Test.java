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
package org.itver.evalpro.servicio;

import java.util.List;
import org.itver.evalpro.dao.DAOFactory;
import org.itver.evalpro.dao.MaestroDAO;
import org.itver.evalpro.dao.MateriaDAO;
import org.itver.evalpro.dao.jpa.DAOJPAFactory;
import org.itver.evalpro.dto.Carrera;
import org.itver.evalpro.dto.Maestro;
import org.itver.evalpro.dto.Materia;

/**
 *
 * @author vrebo
 */
public class Test {

    public static void main(String[] args) {
        Carrera c = new Carrera(1);
        DAOFactory factory =  DAOJPAFactory.getInstance();
        MateriaDAO m = factory.getMateriaDAO();
        List < Materia > resultados = m.buscarPorCarrera(1);
        System.out.println("resultados = " + resultados);
        System.out.printf("Registros en la tabla materia %d\n", m.contar());
        m.cerrar();
        MaestroDAO maestroDAO = factory.getMaestroDAO();
        List<Maestro> maestros = maestroDAO.buscarPorMateria(1);
        for (Maestro maestro : maestros) {
            System.out.println("maestro = " + maestro.getNombre());
        }
    }
}
