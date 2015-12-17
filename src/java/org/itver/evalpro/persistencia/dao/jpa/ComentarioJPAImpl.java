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

import java.util.List;
import javax.persistence.TypedQuery;
import org.itver.evalpro.persistencia.dao.ComentarioDAO;
import org.itver.evalpro.persistencia.dao.dto.Comentario;

/**
 *
 * @author vrebo
 */
class ComentarioJPAImpl
        extends GenericJPAImpl<Comentario, Integer> implements ComentarioDAO {

    public ComentarioJPAImpl() {
        super(Comentario.class);

    }

    @Override
    public List<Comentario> buscarPorIdMaestro(Object idMaestro) {
        TypedQuery<Comentario> query
                = getEntityManager()
                .createNamedQuery("Comentario.findByIdMaestro", Comentario.class);
        query.setParameter("idMaestro", idMaestro);
        List<Comentario> results = query.getResultList();
        return results;
    }

    @Override
    public List<Comentario> buscarPorEstado(Comentario.Estado estado) {
        TypedQuery<Comentario> query
                = getEntityManager()
                .createNamedQuery("Comentario.findByEstado", Comentario.class);
        query.setParameter("estado", estado.toString().toLowerCase());
        List<Comentario> results = query.getResultList();
        return results;
    }

    @Override
    public List<Comentario> buscarComentsProfsEstado(int idMaestro, Comentario.Estado estado) {
        TypedQuery<Comentario> query
                = getEntityManager()
                .createNamedQuery("Comentario.findByEstadoDeProf", Comentario.class);
        query.setParameter("idMaestro", idMaestro);
        query.setParameter("estado", estado.toString().toLowerCase());
        List<Comentario> results = query.getResultList();
        return results;
    }

    @Override
    public List<Comentario> buscarNoCensuradosPorProfesor(int idMaestro) {
        TypedQuery<Comentario> query
                = getEntityManager()
                .createNamedQuery("Comentario.findNotCensoredForProfessor", Comentario.class);
        query.setParameter("idMaestro", idMaestro);
        List<Comentario> results = query.getResultList();
        return results;
    }

}
