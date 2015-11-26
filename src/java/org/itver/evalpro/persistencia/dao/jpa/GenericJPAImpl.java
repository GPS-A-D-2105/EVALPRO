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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itver.evalpro.persistencia.dao.DataAccessObject;
import org.itver.evalpro.persistencia.dao.dto.Entidad;

/**
 * @TODO cambiar la creación del EntityManager durante el uso de los métodos de
 * dao en lugar de hacerlo en el constructor para evitar crear conexiones
 * innecesarias.
 *
 * @Agregar una clase a la API para dar el servicio de persistencia y que
 * funcione como puente entre la API y el cliente que hace uso de ella.
 *
 * @author vrebo
 */
class GenericJPAImpl<E, Id> implements DataAccessObject<E, Id> {

    private final Class<E> clase;
    private EntityManagerFactory emf;
    private EntityManager em;
    private static final String PERSISTENCE_UNIT = "evalproPU";

    public GenericJPAImpl(Class<E> clase) {
        this.clase = clase;
    }

    @Override
    public boolean persistir(E e) {
        EntityManager _em = getEntityManager();
//        EntityTransaction et = _em.getTransaction();
//        et.begin();
        try {
            _em.persist(e);
//            et.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
//            et.rollback();
            return false;
        }
    }

    @Override
    public boolean actualizar(E e) {
        EntityManager _em = getEntityManager();
        EntityTransaction et = _em.getTransaction();
        et.begin();
        try {
            _em.merge(e);
            et.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            et.rollback();
            return false;
        }
    }

    @Override
    public boolean eliminar(E e) {
        EntityManager _em = getEntityManager();
        EntityTransaction et = _em.getTransaction();
        et.begin();

        if (!_em.contains(e) && _em.find(clase, ((Entidad) e).getId()) != null) {
            e = _em.merge(e);
        } else {
            et.rollback();
            return false;
        }

        try {
            _em.remove(e);
            et.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            et.rollback();
            return false;
        }
    }

    @Override
    public E buscarPorId(Id id) {
        EntityManager _em = getEntityManager();
        E entidad = _em.find(clase, id);
        return entidad;
    }

    @Override
    public List<E> buscarPorRangos(int offset, int limite) {
        if (offset < 0) {
            throw new IllegalArgumentException(
                    String.format("Valor de offset inválido, el valor es negativo (%d)", offset));
        }
        if (limite < 0) {
            throw new IllegalArgumentException(
                    String.format("Valor de para limite inválido, el valor es negativo (%d)", offset));
        }
        EntityManager _em = getEntityManager();
        CriteriaQuery cq = _em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(clase));
        Query q = _em.createQuery(cq);
        return q.setFirstResult(offset).getResultList();
    }

    @Override
    public List<E> buscarTodos() {
        getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(clase));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public int contar() {
        EntityManager _em = getEntityManager();
        CriteriaQuery cq = _em.getCriteriaBuilder().createQuery();
        Root<E> rt = cq.from(clase);
        cq.select(_em.getCriteriaBuilder().count(rt));
        Query q = _em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    protected final EntityManager getEntityManager() {
        if (emf == null) {
            emf = javax.persistence.Persistence
                    .createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }

    @Override
    public void cerrar() {
        if(em != null && em.isOpen()){
            em.close();
        }
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }
}

