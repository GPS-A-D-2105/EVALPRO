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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Clase cuyas instancias encapsulan los datos
 *
 * @author vrebo
 */
@Entity
@Table(name = "carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c"),
    @NamedQuery(name = "Carrera.findByIdCarrera", query = "SELECT c FROM Carrera c WHERE c.id = :idCarrera"),
    @NamedQuery(name = "Carrera.findByNombreCarrera", query = "SELECT c FROM Carrera c WHERE c.nombreCarrera = :nombreCarrera")})
public class Carrera extends Entidad<Integer> implements Serializable {
    private List<CarreraMateria> carreraMateriaList;

    private String iconoUrl;

    private static final long serialVersionUID = 1L;

    private String nombreCarrera;

    public Carrera() {
    }

    public Carrera(Integer idCarrera) {
        this.id = idCarrera;
    }

    public Carrera(Integer idCarrera, String nombreCarrera) {
        this.id = idCarrera;
        this.nombreCarrera = nombreCarrera;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarrera")
    @Override
    public Integer getId() {
        return id;
    }

    @Basic(optional = false)
    @Column(name = "nombreCarrera")
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itver.x.dto.Carrera[ idCarrera=" + id + " ]";
    }

    @Column(name = "iconoUrl")
    public String getIconoUrl() {
        return iconoUrl;
    }

    public void setIconoUrl(String iconoUrl) {
        this.iconoUrl = iconoUrl;
    }

@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarrera")
    @XmlTransient
    public List<CarreraMateria> getCarreraMateriaList() {
        return carreraMateriaList;
    }

    public void setCarreraMateriaList(List<CarreraMateria> carreraMateriaList) {
        this.carreraMateriaList = carreraMateriaList;
    }

}
