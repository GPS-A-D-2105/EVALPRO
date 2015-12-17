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
package org.itver.evalpro.persistencia.servicio;

import java.util.List;
import org.itver.evalpro.persistencia.dao.dto.Comentario;

/**
 *
 * @author vrebo
 */
public interface ServicioPersistenciaComentario {
    
    boolean persisitirComentario(Comentario c);
    boolean actualizarComentario(Comentario c);
    boolean eliminarComentario(Comentario c);
    Comentario buscarComentarioPorId(int id);
    List<Comentario> buscarComentarios();
    List<Comentario> buscarComentariosPorRango(int offset,int limite);
    List<Comentario> buscarComentariosPorMaestro(int idMaestro);
    List<Comentario> buscarComentariosPorEstado(Comentario.Estado estado);
    List<Comentario> buscarComentariosPorEstadoDeProf(int idMaestro, Comentario.Estado estado);
    List<Comentario> buscarComentariosNoCensuradorPorProfesor(int idMaestro);
}
