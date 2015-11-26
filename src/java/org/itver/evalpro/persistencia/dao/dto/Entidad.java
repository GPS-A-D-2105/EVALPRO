/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itver.evalpro.persistencia.dao.dto;

/**
 *
 * @author vrebo
 */
public abstract class Entidad<T> {

    protected T id;

    public abstract T getId();

    public void setId(T id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Entidad)) return false;
        Entidad<?> e = (Entidad<?>)obj;
        return id.equals(e.id);
    }

}
