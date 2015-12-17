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
package org.itver.evalpro.persistencia.dao.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Alfonso
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Rese\u00f1a.findAll", query = "SELECT r FROM Rese\u00f1a r"),
    @NamedQuery(name = "Rese\u00f1a.findByIdRese\u00f1a", query = "SELECT r FROM Rese\u00f1a r WHERE r.idRese\u00f1a = :idRese\u00f1a"),
    @NamedQuery(name = "Reseña.findByIdMaestro", query = "SELECT r FROM Reseña r WHERE r.idMaestro.idMaestro = :idMaestro")
})
public class Reseña implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idReseña;
    @JoinColumn(name = "idCarreraMateria", referencedColumnName = "idCarreraMateria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CarreraMateria idCarreraMateria;
    @JoinColumn(name = "idMaestro", referencedColumnName = "idMaestro")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Maestro idMaestro;

    public Reseña() {
    }

    public Reseña(Integer idReseña) {
        this.idReseña = idReseña;
    }

    public Integer getIdReseña() {
        return idReseña;
    }

    public void setIdReseña(Integer idReseña) {
        this.idReseña = idReseña;
    }

    public CarreraMateria getIdCarreraMateria() {
        return idCarreraMateria;
    }

    public void setIdCarreraMateria(CarreraMateria idCarreraMateria) {
        this.idCarreraMateria = idCarreraMateria;
    }

    public Maestro getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(Maestro idMaestro) {
        this.idMaestro = idMaestro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReseña != null ? idReseña.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reseña)) {
            return false;
        }
        Reseña other = (Reseña) object;
        if ((this.idReseña == null && other.idReseña != null) || (this.idReseña != null && !this.idReseña.equals(other.idReseña))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itver.evalpro.persistencia.dao.dto.Rese\u00f1a[ idRese\u00f1a=" + idReseña + " ]";
    }
    
}
