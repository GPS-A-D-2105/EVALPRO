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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m ORDER BY m.nombre"),
    @NamedQuery(name = "Materia.findByIdMateria", query = "SELECT m FROM Materia m WHERE m.idMateria = :idMateria"),
    @NamedQuery(name = "Materia.findByNombreMateria", query = "SELECT m FROM Materia m WHERE m.nombre = :nombreMateria"),
    @NamedQuery(name = "Materia.findByRegistro", query = "SELECT m FROM Materia m WHERE m.registro = :registro"),
    @NamedQuery(name = "Materia.findByCreditos", query = "SELECT m FROM Materia m WHERE m.creditos = :creditos"),
    @NamedQuery(name = "Materia.findByIdCarrera", query = "SELECT m FROM Materia m, CarreraMateria cm WHERE m.idMateria = cm.idMateria.idMateria AND cm.idCarrera.idCarrera = :idCarrera ORDER BY m.nombre"),
    @NamedQuery(name = "Materia.findByIdMaestro", 
            query = "SELECT m FROM Materia m, CarreraMateria cm, Maestro ma, Reseña r WHERE ma.idMaestro = r.idMaestro.idMaestro AND r.idCarreraMateria.idCarreraMateria = cm.idCarreraMateria AND cm.idMateria.idMateria = m.idMateria AND ma.idMaestro = :idMaestro ORDER BY m.nombre")
})
public class Materia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idMateria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String nombre;
    @Basic(optional = false)
//    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    private Character creditos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria", fetch = FetchType.LAZY)
    private List<CarreraMateria> carreraMateriaList;

    public Materia() {
    }

    public Materia(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Materia(Integer idMateria, String nombre, Date registro) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.registro = registro;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public Character getCreditos() {
        return creditos;
    }

    public void setCreditos(Character creditos) {
        this.creditos = creditos;
    }

    public List<CarreraMateria> getCarreraMateriaList() {
        return carreraMateriaList;
    }

    public void setCarreraMateriaList(List<CarreraMateria> carreraMateriaList) {
        this.carreraMateriaList = carreraMateriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itver.evalpro.persistencia.dao.dto.Materia[ idMateria=" + idMateria + " ]";
    }

    

}
