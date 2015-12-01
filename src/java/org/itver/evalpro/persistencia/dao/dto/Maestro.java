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
package org.itver.evalpro.persistencia.dao.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vrebo
 */
@Entity
@Table(name = "maestro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maestro.findAll", query = "SELECT m FROM Maestro m ORDER BY m.nombre"),
    @NamedQuery(name = "Maestro.findByIdMaestro", query = "SELECT m FROM Maestro m WHERE m.idMaestro = :idMaestro"),
    @NamedQuery(name = "Maestro.findByNombre", query = "SELECT m FROM Maestro m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Maestro.findByApellidoPaterno", query = "SELECT m FROM Maestro m WHERE m.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Maestro.findByApellidoMaterno", query = "SELECT m FROM Maestro m WHERE m.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Maestro.findByEmail", query = "SELECT m FROM Maestro m WHERE m.email = :email"),
    @NamedQuery(name = "Maestro.findByRegistro", query = "SELECT m FROM Maestro m WHERE m.registro = :registro"),
    @NamedQuery(name = "Maestro.findByG\u00e9nero", query = "SELECT m FROM Maestro m WHERE m.g\u00e9nero = :g\u00e9nero"),
    @NamedQuery(name = "Maestro.findByMateria",
            query = "SELECT m FROM Maestro m, CarreraMateria cm, Materia ma, Reseña r WHERE m.idMaestro = r.idMaestro.idMaestro AND r.idCarreraMateria.idCarreraMateria = cm.idCarreraMateria AND cm.idMateria.idMateria = ma.idMateria AND ma.idMateria = :idMateria"),
    @NamedQuery(name = "Maestro.findByEstadoComentario", query = "SELECT DISTINCT m FROM Maestro m, Reseña r, Comentario c WHERE m.idMaestro = r.idMaestro.idMaestro AND r.idReseña = c.idReseña.idReseña AND c.estado = :estado")

})
public class Maestro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private int idMaestro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String apellidoPaterno;
    @Size(max = 20)
    private String apellidoMaterno;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String género;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaestro", fetch = FetchType.LAZY)
    private List<Reseña> reseñaList;

    public Maestro() {
    }

    public Maestro(Integer idMaestro) {
        this.idMaestro = idMaestro;
    }

    public Maestro(Integer idMaestro, String nombre, String apellidoPaterno, Date registro, String género) {
        this.idMaestro = idMaestro;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.registro = registro;
        this.género = género;
    }

    public Integer getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(Integer idMaestro) {
        this.idMaestro = idMaestro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public String getGénero() {
        return género;
    }

    public void setGénero(String género) {
        this.género = género;
    }

    public List<Reseña> getReseñaList() {
        return reseñaList;
    }

    public void setReseñaList(List<Reseña> reseñaList) {
        this.reseñaList = reseñaList;
    }

    @Override
    public String toString() {
        return "org.itver.evalpro.persistencia.dao.dto.Maestro[ idMaestro=" + idMaestro + " ]";
    }

}
