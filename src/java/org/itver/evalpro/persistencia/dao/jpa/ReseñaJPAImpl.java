/*
 * Copyright (C) 2015 Alfonso
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
import org.itver.evalpro.persistencia.dao.ReseñaDAO;
import org.itver.evalpro.persistencia.dao.dto.Maestro;
import org.itver.evalpro.persistencia.dao.dto.Reseña;

/**
 *
 * @author Alfonso
 */
public class ReseñaJPAImpl 
        extends GenericJPAImpl<Reseña, Integer> implements ReseñaDAO{

    public ReseñaJPAImpl() {
        super(Reseña.class);
    }

    @Override
    public List<Reseña> buscarPorIdMaestro(int idMaestro) {
        TypedQuery<Reseña> query
                = getEntityManager()
                .createNamedQuery("Reseña.findByIdMaestro", Reseña.class);        
        query.setParameter("idMaestro", idMaestro);
        List<Reseña> results = query.getResultList();
        return results;
    }
    
}
