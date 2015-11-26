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

/**
 * Esta interface define el comportamiento CRUD (Create, Read, Update and
 * Delete) para las clases que la implementen.
 *
 * <ul>
 * <li>Para la operación <i>insert</i> se define el método <i>persistir</i>.
 * </li>
 * <li>Para la operación <i>update</i> se define el método
 * <i>actualizar</i>.</li>
 * <li>Para la operación <i>delete</i> se define el método
 * <i>eliminar</i>.</li>
 * <li>Para la operación <i>read</i> se definen cuatro métodos.
 * <ul>
 * <li><i>buscarPorId</i>.</li>
 * <li><i>buscarTodos</i>.</li>
 * <li><i>buscarPorRango</i>.</li>
 * <li><i>contar</i>.</li>
 * </ul>
 *
 * </li>
 * </ul>
 *
 *
 * @author vrebo
 */
public interface DataAccessObject<E, Id> {

    /**
     * Método que realiza la operación <code>insert</code> dentro de la base de
     * datos la entidad pasada como parámetro. La operación falla si la entidad
     * a insertar tiene un id existente en la BD.
     *
     * @param e Entidad a persistir (insertar) en la BD.
     * @return true si la inserción se completó sin problemas, false en caso
     * contrario.
     */
    boolean persistir(E e);

    /**
     * Realiza un <code>update</code> del registro correspondiente de la entidad
     * <code>e</code> en la BD.
     *
     * @param e Entidad a actualizar
     * @return true si la operación se realizó sin problemas, false en caso
     * contrario.
     */
    boolean actualizar(E e);

    /**
     * Ejecuta la operación <code>delete</code> del registro cuyo primary key
     * corresponde al id de la entidad <code>e</code> en la BD.
     *
     * @param e Entidad a eliminar de la BD.
     * @return true si la entidad fue eliminada sin problemas, false en caso
     * contrario.
     */
    boolean eliminar(E e);

    /**
     * Realiza una consulta en la tabla correspondiente al DAO buscando los
     * datos del registro cuyo id corresponda al del parámetro.
     *
     * @param id El id del registro consultado.
     * @return Una instancia de la entidad, null si la entidad no se encuentra
     * en la BD.
     */
    E buscarPorId(Id id);

    /**
     * Realiza una consulta de los registros en la tabla correspondiente al DAO
     * que se encuentren dentro del rango definido por
     * [offset,...,offset+limite] y los devuelve en un List.
     *
     * ASí pues, si offset = 2 y límite = 5 se obtendrán los primeros 5
     * registros comenzando a partir del registro 2.
     *
     * [2,3,4,5,5,6]
     *
     * Sí, el valor del parámetro límite es 0 se asume que no existe limite
     * límite y el resutado obtenido será un List que contiene todos los
     * registros de la tabla comenzando por offset.
     *
     * @param offset Registro a partir del cual se comenzarán a tomar los
     * registros de la tabla.
     * @param limite Cantidad de registros a tomar.
     * @return Una instancia List que contiene el conjunto de entidades
     * correspondientes a los registros consultados.
     */
    List<E> buscarPorRangos(int offset, int limite);

    /**
     * Consulta todos los registros de la tabla correspondiente al DAO y los
     * devuelve en un List.
     *
     * @return Un List con todos los registros de la tabla.
     */
    List<E> buscarTodos();

    /**
     * Realiza un conteo del total de registros dentro de la tabla sobre la que
     * opera el DAO.
     *
     * @return Un valor entero que representa el total de registros en la tabla.
     */
    int contar();

    /**
     * Este método realiza un cierre de las conexiones que se tengan en la BD.
     * Una vez invocado este método no se podrán realizar más operaciones CRUD.
     */
    void cerrar();
}
