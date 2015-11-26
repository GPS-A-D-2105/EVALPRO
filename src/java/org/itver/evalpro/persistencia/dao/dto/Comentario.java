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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByIdComentario", query = "SELECT c FROM Comentario c WHERE c.id = :idComentario"),
    @NamedQuery(name = "Comentario.findByContenido", query = "SELECT c FROM Comentario c WHERE c.contenido = :contenido"),
    @NamedQuery(name = "Comentario.findByRegistro", query = "SELECT c FROM Comentario c WHERE c.registro = :registro"),
    @NamedQuery(name = "Comentario.findByUsuario", query = "SELECT c FROM Comentario c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Comentario.findByCalifAsist", query = "SELECT c FROM Comentario c WHERE c.califAsist = :califAsist"),
    @NamedQuery(name = "Comentario.findByCalifDomi", query = "SELECT c FROM Comentario c WHERE c.califDomi = :califDomi"),
    @NamedQuery(name = "Comentario.findByCalifCalid", query = "SELECT c FROM Comentario c WHERE c.califCalid = :califCalid"),
    @NamedQuery(name = "Comentario.findByIdMaestro", query = "SELECT c FROM Comentario c, Reseña r WHERE c.idReseña = r.id AND r.idMaestro = :idMaestro ")
})

public class Comentario extends Entidad<Integer> implements Serializable {
    @NotNull
    @Size(min = 1, max = 9)
    private String estado;

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_CALIF_SIZE = 3;

    private String contenido;
    private Date registro;
    private String usuario;
    private final int[] calificaciones;
    private Integer idReseña;

    public Comentario() {
        calificaciones = new int[DEFAULT_CALIF_SIZE];
    }

    public Comentario(Integer idComentario) {
        this();
        this.id = idComentario;
    }

    public Comentario(Integer idComentario, String contenido, int califAsist, int califDomi, int califCalid) {
        this();
        this.id = idComentario;
        this.contenido = contenido;
        calificaciones[0] = califAsist;
        calificaciones[1] = califDomi;
        calificaciones[2] = califCalid;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "idComentario")
    @Override
    public Integer getId() {
        return id;
    }

    @Basic(optional = false)
    @Column(name = "contenido")
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic(optional = false)
    @Column(name = "califAsist")
    public int getCalifAsist() {
        return calificaciones[0];
    }

    public void setCalifAsist(int califAsist) {
        calificaciones[0] = califAsist;
    }

    @Basic(optional = false)
    @Column(name = "califDomi")
    public int getCalifDomi() {
        return calificaciones[1];
    }

    public void setCalifDomi(int califDomi) {
        calificaciones[1] = califDomi;
    }

    @Basic(optional = false)
    @Column(name = "califCalid")
    public int getCalifCalid() {
        return calificaciones[2];
    }

    public void setCalifCalid(int califCalid) {
        calificaciones[2] = califCalid;
    }

    @Column(name = "idReseña")
    public Integer getIdReseña() {
        return idReseña;
    }

    public void setIdReseña(Integer idReseña) {
        this.idReseña = idReseña;
    }

    @Override
    public String toString() {
        return "org.itver.x.dto.Comentario[ idComentario=" + id + " ]";
    }

@Basic(optional = false)
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
