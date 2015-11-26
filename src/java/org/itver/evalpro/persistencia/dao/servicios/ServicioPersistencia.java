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
package org.itver.evalpro.persistencia.dao.servicios;

import java.util.List;
import org.itver.evalpro.persistencia.dao.AbstractFactory;
import org.itver.evalpro.persistencia.dao.AdministradorDAO;
import org.itver.evalpro.persistencia.dao.CarreraDAO;
import org.itver.evalpro.persistencia.dao.ComentarioDAO;
import org.itver.evalpro.persistencia.dao.DAOFactory;
import org.itver.evalpro.persistencia.dao.MaestroDAO;
import org.itver.evalpro.persistencia.dao.MateriaDAO;
import org.itver.evalpro.persistencia.dao.dto.Administrador;
import org.itver.evalpro.persistencia.dao.dto.Carrera;
import org.itver.evalpro.persistencia.dao.dto.Comentario;
import org.itver.evalpro.persistencia.dao.dto.Maestro;
import org.itver.evalpro.persistencia.dao.dto.Materia;

/**
 *
 * @author vrebo
 */
public class ServicioPersistencia
        implements ServicioPersistenciaMaestro,
        ServicioPersistenciaMateria,
        ServicioPersistenciaComentario,
        ServicioPersistenciaCarrera,
        ServicioPersistenciaAdministrador{

    private final ComentarioDAO cmntDAO;
    private final CarreraDAO crraDAO;
    private final MaestroDAO mtroDAO;
    private final MateriaDAO mtraDAO;
    private final AdministradorDAO admnDAO;

    public ServicioPersistencia() {
        DAOFactory factory = AbstractFactory.getDAOFactory();
        cmntDAO = factory.getComentarioDAO();
        crraDAO = factory.getCarreraDAO();
        mtraDAO = factory.getMateriaDAO();
        admnDAO = factory.getAdministradorDAO();
        mtroDAO = factory.getMaestroDAO();
    }

    @Override
    public boolean persistirMaestro(Maestro m) {
        return mtroDAO.persistir(m);
    }

    @Override
    public boolean actualizarMaestro(Maestro m) {
        return mtroDAO.actualizar(m);
    }

    @Override
    public boolean eliminarMaestro(Maestro m) {
        return mtroDAO.eliminar(m);
    }

    @Override
    public Maestro buscarMaestroPorId(int id) {
        return mtroDAO.buscarPorId(id);
    }

    @Override
    public List<Maestro> buscarMaestros() {
        return mtroDAO.buscarTodos();
    }

    @Override
    public List<Maestro> buscarMaestrosPorRango(int offset, int limite) {
        return mtroDAO.buscarPorRangos(offset, limite);
    }

    @Override
    public List<Maestro> buscarMaestrosPorMateria(int idMateria) {
        return mtroDAO.buscarPorMateria(idMateria);
    }

    @Override
    public boolean persistirMateria(Materia m) {
        return mtraDAO.persistir(m);
    }

    @Override
    public boolean actualizarMateria(Materia m) {
        return mtraDAO.actualizar(m);
    }

    @Override
    public boolean eliminarMateria(Materia m) {
        return mtraDAO.eliminar(m);
    }

    @Override
    public Materia buscarMateriaPorId(int id) {
        return mtraDAO.buscarPorId(id);
    }

    @Override
    public List<Materia> buscarMaterias() {
        return mtraDAO.buscarTodos();
    }

    @Override
    public List<Materia> buscarMateriasPorRango(int offset, int limite) {
        return mtraDAO.buscarPorRangos(offset, limite);
    }

    @Override
    public List<Materia> buscarMateriasPorMaestro(int idMaestro) {
        return mtraDAO.buscarPorMaestro(idMaestro);
    }

    @Override
    public List<Materia> buscarMateriasPorCarrera(int idCarrera) {
        return mtraDAO.buscarPorCarrera(idCarrera);
    }

    @Override
    public boolean persisitirComentario(Comentario c) {
        return cmntDAO.persistir(c);
    }

    @Override
    public boolean actualizarComentario(Comentario c) {
        return cmntDAO.actualizar(c);
    }

    @Override
    public boolean eliminarComentario(Comentario c) {
        return cmntDAO.eliminar(c);
    }

    @Override
    public Comentario buscarComentarioPorId(int id) {
        return cmntDAO.buscarPorId(id);
    }

    @Override
    public List<Comentario> buscarComentarios() {
        return cmntDAO.buscarTodos();
    }

    @Override
    public List<Comentario> buscarComentariosPorRango(int offset, int limite) {
        return cmntDAO.buscarPorRangos(offset, limite);
    }

    @Override
    public List<Comentario> buscarComentariosPorMaestro(int idMaestro) {
        return cmntDAO.buscarPorIdMaestro(idMaestro);
    }

    @Override
    public boolean persistirCarrera(Carrera c) {
        return crraDAO.persistir(c);
    }

    @Override
    public boolean actualizarCarrera(Carrera c) {
        return crraDAO.actualizar(c);
    }

    @Override
    public boolean eliminarCarrra(Carrera c) {
        return crraDAO.eliminar(c);
    }

    @Override
    public Carrera buscarCarreraId(int id) {
        return crraDAO.buscarPorId(id);
    }

    @Override
    public List<Carrera> buscarCarreras() {
        return crraDAO.buscarTodos();
    }

    @Override
    public List<Carrera> buscarCarrerasPorRango(int offset, int limite) {
        return crraDAO.buscarPorRangos(offset, limite);
    }
    
    public void cerrarServicio() {
        mtraDAO.cerrar();
        mtroDAO.cerrar();
        cmntDAO.cerrar();
        crraDAO.cerrar();
        admnDAO.cerrar();
    }

    @Override
    public boolean persisitirAdministrador(Administrador a) {
        return admnDAO.persistir(a);
    }

    @Override
    public boolean actualizarAdministrador(Administrador a) {
        return admnDAO.actualizar(a);
    }

    @Override
    public boolean eliminarAdministrador(Administrador a) {
        return admnDAO.eliminar(a);
    }

    @Override
    public Administrador buscarAdministradorPorId(String id) {
        return admnDAO.buscarPorId(id);
    }

    @Override
    public List<Administrador> buscarAdministradores() {
        return admnDAO.buscarTodos();
    }
}
