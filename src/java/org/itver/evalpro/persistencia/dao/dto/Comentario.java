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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Comentario.findByIdComentario", query = "SELECT c FROM Comentario c WHERE c.idComentario = :idComentario"),
    @NamedQuery(name = "Comentario.findByContenido", query = "SELECT c FROM Comentario c WHERE c.contenido = :contenido"),
    @NamedQuery(name = "Comentario.findByRegistro", query = "SELECT c FROM Comentario c WHERE c.registro = :registro"),
    @NamedQuery(name = "Comentario.findByUsuario", query = "SELECT c FROM Comentario c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Comentario.findByCalifAsist", query = "SELECT c FROM Comentario c WHERE c.califAsist = :califAsist"),
    @NamedQuery(name = "Comentario.findByCalifDomi", query = "SELECT c FROM Comentario c WHERE c.califDomi = :califDomi"),
    @NamedQuery(name = "Comentario.findByCalifCalid", query = "SELECT c FROM Comentario c WHERE c.califCalid = :califCalid"),
    @NamedQuery(name = "Comentario.findByIdMaestro", query = "SELECT c FROM Comentario c, Reseña r WHERE c.idReseña.idReseña = r.idReseña AND r.idMaestro.idMaestro = :idMaestro "),
    @NamedQuery(name = "Comentario.findByEstado", 
            query = "SELECT c FROM Comentario c "
                    + "WHERE c.estado = :estado "
                    + "ORDER BY c.registro DESC"),
    @NamedQuery(name = "Comentario.findByEstadoDeProf", 
            query = "SELECT c FROM Reseña r, Comentario c "
                    + "WHERE r.idMaestro.idMaestro = :idMaestro "
                    + "AND r.idReseña = c.idReseña.idReseña "
                    + "AND c.estado = :estado ORDER BY c.registro DESC")
})

public class Comentario implements Serializable {

    public enum Estado {
        ESPERA, APROBADO, CENSURADO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idComentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 140)
    private String contenido;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    @Size(max = 20)
    private String usuario;
    @Basic(optional = false)
    @NotNull
    private int califAsist;
    @Basic(optional = false)
    @NotNull
    private int califDomi;
    @Basic(optional = false)
    @NotNull
    private int califCalid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    private String estado;

    @JoinColumn(name = "idRese\u00f1a", referencedColumnName = "idRese\u00f1a")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Reseña idReseña;

    public Comentario() {
    }

    public Comentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Comentario(Integer idComentario, String contenido, Date registro, int califAsist, int califDomi, int califCalid, String estado) {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.registro = registro;
        this.califAsist = califAsist;
        this.califDomi = califDomi;
        this.califCalid = califCalid;
        this.estado = estado;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getCalifAsist() {
        return califAsist;
    }

    public void setCalifAsist(int califAsist) {
        this.califAsist = califAsist;
    }

    public int getCalifDomi() {
        return califDomi;
    }

    public void setCalifDomi(int califDomi) {
        this.califDomi = califDomi;
    }

    public int getCalifCalid() {
        return califCalid;
    }

    public void setCalifCalid(int califCalid) {
        this.califCalid = califCalid;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Reseña getIdReseña() {
        return idReseña;
    }

    public void setIdReseña(Reseña idReseña) {
        this.idReseña = idReseña;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itver.evalpro.persistencia.dao.dto.Comentario[ idComentario=" + idComentario + " ]";
    }

}
