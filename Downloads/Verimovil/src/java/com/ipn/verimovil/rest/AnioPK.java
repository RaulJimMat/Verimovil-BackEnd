/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimovil.rest;

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
public class AnioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idAnio")
    private int idAnio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Modelo_idModelo")
    private int modeloidModelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Modelo_Marca_idMarca")
    private int modeloMarcaidMarca;

    public AnioPK() {
    }

    public AnioPK(int idAnio, int modeloidModelo, int modeloMarcaidMarca) {
        this.idAnio = idAnio;
        this.modeloidModelo = modeloidModelo;
        this.modeloMarcaidMarca = modeloMarcaidMarca;
    }

    public int getIdAnio() {
        return idAnio;
    }

    public void setIdAnio(int idAnio) {
        this.idAnio = idAnio;
    }

    public int getModeloidModelo() {
        return modeloidModelo;
    }

    public void setModeloidModelo(int modeloidModelo) {
        this.modeloidModelo = modeloidModelo;
    }

    public int getModeloMarcaidMarca() {
        return modeloMarcaidMarca;
    }

    public void setModeloMarcaidMarca(int modeloMarcaidMarca) {
        this.modeloMarcaidMarca = modeloMarcaidMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAnio;
        hash += (int) modeloidModelo;
        hash += (int) modeloMarcaidMarca;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnioPK)) {
            return false;
        }
        AnioPK other = (AnioPK) object;
        if (this.idAnio != other.idAnio) {
            return false;
        }
        if (this.modeloidModelo != other.modeloidModelo) {
            return false;
        }
        if (this.modeloMarcaidMarca != other.modeloMarcaidMarca) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipn.verimov.modelo.AnioPK[ idAnio=" + idAnio + ", modeloidModelo=" + modeloidModelo + ", modeloMarcaidMarca=" + modeloMarcaidMarca + " ]";
    }
    
}
