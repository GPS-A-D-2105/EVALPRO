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
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m ORDER BY m.nombreMateria"),
    @NamedQuery(name = "Materia.findByIdMateria", query = "SELECT m FROM Materia m WHERE m.id = :idMateria"),
    @NamedQuery(name = "Materia.findByNombreMateria", query = "SELECT m FROM Materia m WHERE m.nombreMateria = :nombreMateria"),
    @NamedQuery(name = "Materia.findByRegistro", query = "SELECT m FROM Materia m WHERE m.registro = :registro"),
    @NamedQuery(name = "Materia.findByCreditos", query = "SELECT m FROM Materia m WHERE m.creditos = :creditos"),
    @NamedQuery(name = "Materia.findByIdCarrera", query = "SELECT m FROM Materia m, CarreraMateria cm WHERE m.id = cm.idMateria AND cm.idCarrera = :idCarrera ORDER BY m.nombreMateria"),
    @NamedQuery(name = "Materia.findByIdMaestro", 
            query = "SELECT m FROM Materia m, CarreraMateria cm, Maestro ma, Reseña r WHERE ma.id = r.idMaestro AND r.idCarreraMateria = cm.id AND cm.idMateria = m.id AND ma.id = :idMaestro ORDER BY m.nombreMateria")
})
public class Materia extends Entidad<Integer> implements Serializable {
    private List<CarreraMateria> carreraMateriaList;

    private static final long serialVersionUID = 1L;

    private String nombreMateria;
    private Date registro;
    private Character creditos;

    public Materia() {
    }

    public Materia(Integer idMateria) {
        this.id = idMateria;
    }

    public Materia(Integer idMateria, String nombreMateria) {
        this.id = idMateria;
        this.nombreMateria = nombreMateria;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMateria")
    @Override
    public Integer getId() {
        return id;
    }

    @Basic(optional = false)
    @Column(name = "nombreMateria")
    public String getNombreMateria() {
        return nombreMateria;
    }

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRegistro() {
        return registro;
    }

    @Column(name = "creditos")
    public Character getCreditos() {
        return creditos;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public void setCreditos(Character creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "org.itver.x.dto.Materia[ idMateria=" + id + " ]";
    }

@OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria")
    @XmlTransient
    public List<CarreraMateria> getCarreraMateriaList() {
        return carreraMateriaList;
    }

    public void setCarreraMateriaList(List<CarreraMateria> carreraMateriaList) {
        this.carreraMateriaList = carreraMateriaList;
    }

}
