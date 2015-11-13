package org.itver.evalpro.servicio;

import java.util.List;
import org.itver.evalpro.dao.AbstractFactory;
import org.itver.evalpro.dao.AdministradorDAO;
import org.itver.evalpro.dao.CarreraDAO;
import org.itver.evalpro.dao.DAOFactory;
import org.itver.evalpro.dao.MaestroDAO;
import org.itver.evalpro.dao.MateriaDAO;
import org.itver.evalpro.dto.Administrador;
import org.itver.evalpro.dto.Carrera;
import org.itver.evalpro.dto.Maestro;
import org.itver.evalpro.dto.Materia;

/**
 *  TODO Agregar la documentación de la clase, sus atributos y métodos
 * @author vrebo
 */
public class ServicioPersistencia {
//    private final ComentarioDAO   comentarioDAO;
    private final CarreraDAO carreraDAO;
    private final MaestroDAO      maestroDAO;
    private final MateriaDAO materiaDAO;
    private final AdministradorDAO adminDAO;

    public ServicioPersistencia() {
        DAOFactory factory = AbstractFactory.getDAOFactory();
        carreraDAO  = factory.getCarreraDAO();
        materiaDAO  = factory.getMateriaDAO();
        adminDAO    = factory.getAdministradorDAO();
        maestroDAO  = factory.getMaestroDAO();
    }

    //Servicios para la entidad carrera
    public void persistirCarrera(Carrera c) {
        carreraDAO.persistir(c);
    }

    public void actualizarCarrera(Carrera c) {
        carreraDAO.actualizar(c);
    }

    public void eliminarCarrera(Carrera c) {
        carreraDAO.eliminar(c);
    }

    public Carrera buscarCarreraPorId(int id) {
        return carreraDAO.buscarPorId(id);
    }

    public List<Carrera> buscarTodasCarreras() {
        return carreraDAO.buscarTodos();
    }

    public List<Carrera> buscarCarrerasPorRango(int offset, int limite) {
        return carreraDAO.buscarPorRangos(offset, limite);
    }

    //Servicios para la entidad Materia
    public void persistirMateria(Materia m) {
        materiaDAO.persistir(m);
    }

    public void actualizarMateria(Materia m) {
        materiaDAO.actualizar(m);
    }

    public void eliminarMateria(Materia m) {
        materiaDAO.eliminar(m);
    }

    public Materia buscarMateriaPorId(int id) {
        return materiaDAO.buscarPorId(id);
    }

    public List<Materia> buscarTodasMateria() {
        return materiaDAO.buscarTodos();
    }
    
    public List<Materia> buscarMateriasPorMaestro(int idMaestro) {
        return materiaDAO.buscarPorMaestro(idMaestro);
    }
    //estás horny

    public List<Materia> buscarMateriasPorRango(int offset, int limite) {
        return materiaDAO.buscarPorRangos(offset, limite);
    }
    
    public List<Materia> buscarMateriaPorCarrera(int idCarrera){
        return materiaDAO.buscarPorCarrera(idCarrera);
    }
    
    //Servicios para la entidad Administrador
    public void persistirAdmin(Administrador a) {
        adminDAO.persistir(a);
    }

    public void actualizarAdmin(Administrador a) {
        adminDAO.actualizar(a);
    }

    public void eliminarMateria(Administrador m) {
        adminDAO.eliminar(m);
    }

    public Administrador buscarAdminPorId(String id) {
        return adminDAO.buscarPorId(id);
    }

    public List<Administrador> buscarTodosAdmins() {
        return adminDAO.buscarTodos();
    }

    public List<Administrador> buscarAdminsPorRango(int offset, int limite) {
        return adminDAO.buscarPorRangos(offset, limite);
    }
    
    //Servicios para profesores
    public void persistirMaestro(Maestro m) {
        maestroDAO.persistir(m);
    }

    public void actualizarMaestro(Maestro m) {
        maestroDAO.actualizar(m);
    }

    public void eliminarMaestro(Maestro m) {
        maestroDAO.eliminar(m);
    }

    public Maestro buscarMaestroPorId(int id) {
        return maestroDAO.buscarPorId(id);
    }

    public List<Maestro> buscarMaestros() {
        return maestroDAO.buscarTodos();
    }

    public List<Maestro> buscarMaestrosPorRango(int offset, int limite) {
        return maestroDAO.buscarPorRangos(offset, limite);
    }
    
    public List<Maestro> buscarMaestrosPorMateria(int idMateria){
        return maestroDAO.buscarPorMateria(idMateria);
    }
}
