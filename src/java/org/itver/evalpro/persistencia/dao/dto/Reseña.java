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
import javax.persistence.FetchType;
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
 *
 * @author vrebo
 */
@Entity
@Table(name = "rese\u00f1a")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rese\u00f1a.findAll", query = "SELECT r FROM Rese\u00f1a r"),
    @NamedQuery(name = "Rese\u00f1a.findByIdRese\u00f1a", query = "SELECT r FROM Rese\u00f1a r WHERE r.id = :idRese\u00f1a")})
public class Reseña extends Entidad<Integer> implements Serializable {
    private List<Comentario> comentarioList;

    private static final long serialVersionUID = 1L;
    private Integer idMaestro;
    private Integer idCarreraMateria;

    public Reseña() {
    }

    public Reseña(Integer idReseña) {
        this.id = idReseña;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRese\u00f1a")
    @Override
    public Integer getId() {
        return id;
    }

    @Column(name = "idMaestro")
    public Integer getIdMaestro() {
        return idMaestro;
    }

    @Column(name = "idCarreraMateria")
    public Integer getIdCarreraMateria() {
        return idCarreraMateria;
    }

    public void setIdMaestro(Integer idMaestro) {
        this.idMaestro = idMaestro;
    }

    public void setIdCarreraMateria(Integer idCarreraMateria) {
        this.idCarreraMateria = idCarreraMateria;
    }

    @Override
    public String toString() {
        return "org.itver.x.dto.Rese\u00f1a[ idRese\u00f1a=" + id + " ]";
    }

@OneToMany(cascade = CascadeType.ALL, mappedBy = "idRese\u00f1a")
    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }
}
