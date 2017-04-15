/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Raul
 */
@Embeddable
public class ModeloPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idModelo")
    private int idModelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Marca_idMarca")
    private int marcaidMarca;

    public ModeloPK() {
    }

    public ModeloPK(int idModelo, int marcaidMarca) {
        this.idModelo = idModelo;
        this.marcaidMarca = marcaidMarca;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getMarcaidMarca() {
        return marcaidMarca;
    }

    public void setMarcaidMarca(int marcaidMarca) {
        this.marcaidMarca = marcaidMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idModelo;
        hash += (int) marcaidMarca;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeloPK)) {
            return false;
        }
        ModeloPK other = (ModeloPK) object;
        if (this.idModelo != other.idModelo) {
            return false;
        }
        if (this.marcaidMarca != other.marcaidMarca) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipn.verimov.modelo.ModeloPK[ idModelo=" + idModelo + ", marcaidMarca=" + marcaidMarca + " ]";
    }
    
}
