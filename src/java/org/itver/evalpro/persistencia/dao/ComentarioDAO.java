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

import java.util.List;
import org.itver.evalpro.persistencia.dao.dto.Comentario;

/**
 *
 * @author vrebo
 */
public interface ComentarioDAO extends DataAccessObject<Comentario, Integer>{
    
    List<Comentario> buscarPorIdMaestro(Object idMaestro);
    List<Comentario> buscarPorEstado(Comentario.Estado estado);
    List<Comentario> buscarComentsProfsEstado(int idMaestro, 
                                              Comentario.Estado estado);
    List<Comentario> buscarNoCensuradosPorProfesor(int idMaestro);
}
