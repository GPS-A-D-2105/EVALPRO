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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vrebo
 */
@Entity
@Table(name = "maestro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maestro.findAll", query = "SELECT m FROM Maestro m ORDER BY nombre"),
    @NamedQuery(name = "Maestro.findByIdMaestro", query = "SELECT m FROM Maestro m WHERE m.id = :idMaestro"),
    @NamedQuery(name = "Maestro.findByNombre", query = "SELECT m FROM Maestro m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Maestro.findByApellidoPaterno", query = "SELECT m FROM Maestro m WHERE m.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Maestro.findByApellidoMaterno", query = "SELECT m FROM Maestro m WHERE m.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Maestro.findByEmail", query = "SELECT m FROM Maestro m WHERE m.email = :email"),
    @NamedQuery(name = "Maestro.findByRegistro", query = "SELECT m FROM Maestro m WHERE m.registro = :registro"),
    @NamedQuery(name = "Maestro.findByG\u00e9nero", query = "SELECT m FROM Maestro m WHERE m.g\u00e9nero = :g\u00e9nero"),
    @NamedQuery(name = "Maestro.findByMateria", 
            query = "SELECT m FROM Maestro m, CarreraMateria cm, Materia ma, Reseña r WHERE m.id = r.idMaestro AND r.idCarreraMateria = cm.id AND cm.idMateria = ma.id AND ma.id = :idMateria")
})
public class Maestro extends Entidad<Integer> implements Serializable {
    private List<Reseña> reseñaList;

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private Date registro;
    private String género;

    public Maestro() {
    }

    public Maestro(Integer idMaestro) {
        this.id = idMaestro;
    }

    public Maestro(Integer idMaestro, String nombre, String apellidoPaterno, Date registro, String género) {
        this.id = idMaestro;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.registro = registro;
        this.género = género;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaestro")
    @Override
    public Integer getId() {
        return id;
    }

    @Basic(optional = false)
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    @Basic(optional = false)
    @Column(name = "apellidoPaterno")
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    @Column(name = "apellidoMaterno")
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Basic(optional = false)
    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRegistro() {
        return registro;
    }

    @Basic(optional = false)
    @Column(name = "g\u00e9nero")
    public String getGénero() {
        return género;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public void setGénero(String género) {
        this.género = género;
    }

    @Override
    public String toString() {
        return "org.itver.x.dto.Maestro[ idMaestro=" + id + " ]";
    }

@OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaestro")
    @XmlTransient
    public List<Reseña> getReseñaList() {
        return reseñaList;
    }

    public void setReseñaList(List<Reseña> reseñaList) {
        this.reseñaList = reseñaList;
    }

}
