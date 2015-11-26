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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.itver.evalpro.persistencia.dao.dto.Carrera;
import org.itver.evalpro.persistencia.dao.dto.Materia;
import org.itver.evalpro.persistencia.dao.dto.Reseña;

/**
 *
 * @author vrebo
 */
@Entity
@Table(name = "carrera_materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarreraMateria.findAll", query = "SELECT c FROM CarreraMateria c"),
    @NamedQuery(name = "CarreraMateria.findByIdCarreraMateria", query = "SELECT c FROM CarreraMateria c WHERE c.idCarreraMateria = :idCarreraMateria")})
public class CarreraMateria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarreraMateria")
    private Integer idCarreraMateria;
    @JoinColumn(name = "idCarrera", referencedColumnName = "idCarrera")
    @ManyToOne(optional = false)
    private Carrera idCarrera;
    @JoinColumn(name = "idMateria", referencedColumnName = "idMateria")
    @ManyToOne(optional = false)
    private Materia idMateria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarreraMateria")
    private List<Reseña> reseñaList;

    public CarreraMateria() {
    }

    public CarreraMateria(Integer idCarreraMateria) {
        this.idCarreraMateria = idCarreraMateria;
    }

    public Integer getIdCarreraMateria() {
        return idCarreraMateria;
    }

    public void setIdCarreraMateria(Integer idCarreraMateria) {
        this.idCarreraMateria = idCarreraMateria;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    @XmlTransient
    public List<Reseña> getReseñaList() {
        return reseñaList;
    }

    public void setReseñaList(List<Reseña> reseñaList) {
        this.reseñaList = reseñaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarreraMateria != null ? idCarreraMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarreraMateria)) {
            return false;
        }
        CarreraMateria other = (CarreraMateria) object;
        if ((this.idCarreraMateria == null && other.idCarreraMateria != null) || (this.idCarreraMateria != null && !this.idCarreraMateria.equals(other.idCarreraMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itver.evalpro.persistencia.dao.CarreraMateria[ idCarreraMateria=" + idCarreraMateria + " ]";
    }
    
}
